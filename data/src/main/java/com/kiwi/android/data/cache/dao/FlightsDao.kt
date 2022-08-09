package com.kiwi.android.data.cache.dao

import androidx.room.*
import com.kiwi.android.data.cache.model.CachedAvailability
import com.kiwi.android.data.cache.model.CachedCountry
import com.kiwi.android.data.cache.model.CachedFlight
import com.kiwi.android.data.cache.model.CachedFlightAggregate
import kotlinx.coroutines.flow.Flow

@Dao
abstract class FlightsDao {

    @Transaction
    @Query("SELECT * FROM tbl_flights")
    abstract fun getAllFlightsFlowable(): Flow<List<CachedFlightAggregate>>

    @Transaction
    @Query("SELECT * FROM tbl_flights")
    abstract suspend fun getAllFlights(): List<CachedFlightAggregate>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertFlightAggregate(
        flight: CachedFlight,
        countries: List<CachedCountry>,
        availability: CachedAvailability
    )

    suspend fun insertFlights(flightsAggregate: List<CachedFlightAggregate>) {
        flightsAggregate.forEach { aggregate ->
            insertFlightAggregate(
                flight = aggregate.flight,
                countries = aggregate.countries,
                availability = aggregate.availability
            )
        }
    }

    @Query("DELETE FROM tbl_flights")
    abstract suspend fun deleteFlights()

}