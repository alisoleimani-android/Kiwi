package com.kiwi.android.data.repository

import com.kiwi.android.data.api.KiwiApi
import com.kiwi.android.data.api.NetworkCallHandler
import com.kiwi.android.data.api.model.mapper.ApiFlightMapper
import com.kiwi.android.data.cache.Cache
import com.kiwi.android.data.cache.model.CachedFlightAggregate
import com.kiwi.android.domain.model.Flight
import com.kiwi.android.domain.repository.AppRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val api: KiwiApi,
    private val cache: Cache,
    private val networkCallHandler: NetworkCallHandler,
    private val apiFlightMapper: ApiFlightMapper
) : AppRepository {

    override fun getFlightsFlowable(): Flow<List<Flight>> {
        return cache.getFlightsFlowable()
            .distinctUntilChanged()
            .map { list ->
                list.map { item ->
                    item.flight.toFlightDomain(item.countries, item.availability)
                }
            }
    }

    override suspend fun getFlights(): List<Flight> {
        return cache.getFlights().map { it.flight.toFlightDomain(it.countries, it.availability) }
    }

    override suspend fun storeFlights(flights: List<Flight>) {
        cache.storeFlights(flights.map { CachedFlightAggregate.fromDomain(it) })
    }

    override suspend fun deleteFlights() {
        cache.deleteFlights()
    }

    override suspend fun requestGetFlights(dateFrom: String): Result<List<Flight>> =
        networkCallHandler.call {
            val response = api.getFlights(dateFrom = dateFrom)
            response.data.map { apiFlightMapper.mapToDomain(it) }
        }

}