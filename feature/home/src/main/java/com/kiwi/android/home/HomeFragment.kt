package com.kiwi.android.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.snackbar.Snackbar
import com.kiwi.android.core.collectOn
import com.kiwi.android.home.databinding.FragmentHomeBinding
import com.kiwi.android.ui.model.Event
import com.kiwi.android.ui.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)

    private val viewModel by viewModels<HomeViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        observeViewStateUpdates()
    }

    private fun observeViewStateUpdates() {
        viewModel.uiState.collectOn(viewLifecycleOwner) {
            updateScreenState(it)
        }
    }

    private fun updateScreenState(state: HomeUiState) {
        handleFailures(state.failure)
    }

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

}