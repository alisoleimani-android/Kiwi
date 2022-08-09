package com.kiwi.android.domain.repository

import com.kiwi.android.domain.model.Flight
import kotlinx.coroutines.flow.Flow

interface AppRepository {
    fun getFlightsFlowable(): Flow<List<Flight>>

    suspend fun getFlights(): List<Flight>

    suspend fun storeFlights(flights: List<Flight>)

    suspend fun deleteFlights()

    suspend fun requestGetFlights(dateFrom: String): Result<List<Flight>>
}