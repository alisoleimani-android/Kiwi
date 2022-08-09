package com.kiwi.android.domain.usecase

import com.kiwi.android.domain.model.Flight
import kotlinx.coroutines.flow.Flow

interface GetFlights {
    operator fun invoke(): Flow<List<Flight>>
}