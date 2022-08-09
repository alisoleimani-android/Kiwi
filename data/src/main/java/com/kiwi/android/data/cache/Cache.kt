package com.kiwi.android.data.cache

import com.kiwi.android.data.cache.model.CachedFlightAggregate
import kotlinx.coroutines.flow.Flow

interface Cache {

    suspend fun storeFlights(flights: List<CachedFlightAggregate>)

    fun getFlightsFlowable(): Flow<List<CachedFlightAggregate>>

    suspend fun getFlights(): List<CachedFlightAggregate>

    suspend fun deleteFlights()

}