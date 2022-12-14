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
import kotlinx.coroutines.flow.update
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

    private val exceptionHandler
        get() = viewModelScope.createExceptionHandler { throwable ->
            _uiState.update { it.copy(loading = false, failure = Event(throwable)) }
        }

    init {
        subscribeToFlightUpdates()
        updateSuggestions()
    }

    private fun subscribeToFlightUpdates() {
        getFlights().collectOn(viewModelScope) { suggestedFlights ->
            _uiState.update { uiState ->
                uiState.copy(
                    suggestedFlights = suggestedFlights.map { uiFlightMapper.mapToView(it) }
                )
            }
        }
    }

    private fun updateSuggestions() {
        viewModelScope.launch(exceptionHandler) {

            _uiState.update { it.copy(loading = true) }

            requestUpdateSuggestions()

            _uiState.update { it.copy(loading = false) }
        }
    }

}