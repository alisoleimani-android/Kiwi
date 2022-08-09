package com.kiwi.android.data.cache

import com.kiwi.android.core.DispatchersProvider
import com.kiwi.android.data.cache.dao.FlightsDao
import com.kiwi.android.data.cache.model.CachedFlightAggregate
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RoomCache @Inject constructor(
    private val flightsDao: FlightsDao,
    private val dispatchers: DispatchersProvider
) : Cache {
    override suspend fun storeFlights(flights: List<CachedFlightAggregate>) {
        withContext(dispatchers.io()) {
            flightsDao.insertFlights(flights)
        }
    }

    override fun getFlightsFlowable(): Flow<List<CachedFlightAggregate>> {
        return flightsDao.getAllFlightsFlowable()
    }

    override suspend fun getFlights(): List<CachedFlightAggregate> {
        return withContext(dispatchers.io()) {
            flightsDao.getAllFlights()
        }
    }

    override suspend fun deleteFlights() {
        withContext(dispatchers.io()) {
            flightsDao.deleteFlights()
        }
    }
}