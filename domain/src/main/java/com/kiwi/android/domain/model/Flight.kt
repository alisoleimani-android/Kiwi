package com.kiwi.android.domain.model

data class Flight(
    val id: String,
    val cityFrom: String,
    val cityTo: String,
    val countryFrom: Country,
    val countryTo: Country,
    val distance: Double,
    val popularity: Long,
    val flyDuration: String,
    val availability: FlyAvailability,
    val destinationId: String
)

data class Country(
    val code: String,
    val name: String
)

data class FlyAvailability(
    val seats: Int
)
