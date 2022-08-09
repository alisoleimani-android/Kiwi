package com.kiwi.android.data.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kiwi.android.domain.model.Flight

@Entity(tableName = "tbl_flights")
data class CachedFlight(
    @PrimaryKey
    val id: String,
    val cityFrom: String,
    val cityTo: String,
    val distance: Double,
    val popularity: Long,
    val flyDuration: String,
    val destinationId: String
) {
    companion object {
        fun fromDomain(flight: Flight): CachedFlight = CachedFlight(
            id = flight.id,
            cityFrom = flight.cityFrom,
            cityTo = flight.cityTo,
            distance = flight.distance,
            popularity = flight.popularity,
            flyDuration = flight.flyDuration,
            destinationId = flight.destinationId
        )
    }

    fun toFlightDomain(
        countries: List<CachedCountry>,
        availability: CachedAvailability
    ): Flight = Flight(
        id = id,
        cityFrom = cityFrom,
        cityTo = cityTo,
        countryFrom = countries[0].toDomain(),
        countryTo = countries[1].toDomain(),
        distance = distance,
        popularity = popularity,
        flyDuration = flyDuration,
        availability = availability.toDomain(),
        destinationId = destinationId
    )
}
