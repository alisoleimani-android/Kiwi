package com.kiwi.android.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kiwi.android.core.collectOn
import com.kiwi.android.core.createExceptionHandler
import com.kiwi.android.domain.usecase.GetFlights
import com.kiwi.android.domain.usecase.RequestUpdateSuggestions
import com.kiwi.android.home.model.UiFlightMapper
import com.kiwi.android.ui.model.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getFlights: GetFlights,
    private val requestUpdateSuggestions: RequestUpdateSuggestions,
    private val uiFlightMapper: UiFlightMapper
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState

    private val currentState get() = uiState.value

    private val exceptionHandler
        get() = viewModelScope.createExceptionHandler {
            _uiState.value = currentState.copy(loading = false, failure = Event(it))
        }

    init {
        subscribeToFlightUpdates()
        updateSuggestions()
    }

    private fun subscribeToFlightUpdates() {
        getFlights().collectOn(viewModelScope) { suggestedFlights ->
            _uiState.value = currentState.copy(
                suggestedFlights = suggestedFlights.map { uiFlightMapper.mapToView(it) }
            )
        }
    }

    private fun updateSuggestions () {
        viewModelScope.launch(exceptionHandler) {

            _uiState.value = currentState.copy(loading = true)

            requestUpdateSuggestions()

            _uiState.value = currentState.copy(loading = false)
        }
    }

}