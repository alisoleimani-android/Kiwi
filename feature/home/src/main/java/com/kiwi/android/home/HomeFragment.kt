package com.kiwi.android.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.snackbar.Snackbar
import com.kiwi.android.core.Theme
import com.kiwi.android.core.collectOn
import com.kiwi.android.domain.preferences.Preferences
import com.kiwi.android.home.databinding.FragmentHomeBinding
import com.kiwi.android.ui.model.Event
import com.kiwi.android.ui.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)

    private val viewModel by viewModels<HomeViewModel>()

    @Inject
    lateinit var preferences: Preferences

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        setupToolbar()

        val adapter = createAdapter()
        setupRecyclerView(adapter)

        observeViewStateUpdates(adapter)
    }

    private fun setupToolbar() {
        when (preferences.theme) {
            Theme.DARK -> {
                binding.toolbar.menu.findItem(R.id.item_theme_mode)
                    .setIcon(R.drawable.ic_light_mode)
            }
            Theme.LIGHT -> {
                binding.toolbar.menu.findItem(R.id.item_theme_mode)
                    .setIcon(R.drawable.ic_night_mode)
            }
        }

        binding.toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.item_theme_mode -> switchTheme()
            }
            true
        }
    }

    private fun setupRecyclerView(adapter: FlightsListAdapter) {
        binding.flightList.apply {
            this.adapter = adapter
            setHasFixedSize(true)
        }
    }

    private fun observeViewStateUpdates(adapter: FlightsListAdapter) {
        viewModel.uiState.collectOn(viewLifecycleOwner) {
            updateScreenState(it, adapter)
        }
    }

    private fun updateScreenState(state: HomeUiState, adapter: FlightsListAdapter) {
        binding.uiState = state
        adapter.submitList(state.suggestedFlights)
        handleFailures(state.failure)
    }

    private fun createAdapter() = FlightsListAdapter()

    private fun handleFailures(failure: Event<Throwable>?) {
        val unhandledFailure = failure?.getContentIfNotHandled() ?: return
        val fallbackMessage = getString(com.kiwi.android.resource.R.string.msg_an_error_occurred)
        val throwableMessage = unhandledFailure.message

        val snackbarMessage = if (throwableMessage.isNullOrEmpty()) {
            fallbackMessage
        } else {
            throwableMessage
        }

        if (snackbarMessage.isNotEmpty()) {
            Snackbar.make(requireView(), snackbarMessage, Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun switchTheme() {
        val newTheme = when (preferences.theme) {
            Theme.DARK -> Theme.LIGHT
            Theme.LIGHT -> Theme.DARK
        }
        preferences.theme = newTheme
    }

}