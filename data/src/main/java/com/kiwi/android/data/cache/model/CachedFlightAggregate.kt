package com.kiwi.android.data.cache.model

import androidx.room.Embedded
import androidx.room.Relation
import com.kiwi.android.domain.model.Flight

data class CachedFlightAggregate(
    @Embedded
    val flight: CachedFlight,

    @Relation(parentColumn = "id", entityColumn = "flightId")
    val countries: List<CachedCountry>,

    @Relation(parentColumn = "id", entityColumn = "flightId")
    val availability: CachedAvailability
) {
    companion object {
        fun fromDomain(flight: Flight): CachedFlightAggregate {
            return CachedFlightAggregate(
                flight = CachedFlight.fromDomain(flight),
                countries = listOf(flight.countryFrom, flight.countryTo).map {
                    CachedCountry.fromDomain(flight.id, it)
                },
                availability = CachedAvailability.fromDomain(flight.id, flight.availability)
            )
        }
    }
}
