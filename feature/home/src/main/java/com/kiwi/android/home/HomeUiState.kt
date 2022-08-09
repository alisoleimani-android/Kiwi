package com.kiwi.android.home

import com.kiwi.android.home.model.UiFlight
import com.kiwi.android.ui.model.Event

data class HomeUiState(
    val loading: Boolean = false,
    val suggestedFlights: List<UiFlight> = emptyList(),
    val failure: Event<Throwable>? = null,
)