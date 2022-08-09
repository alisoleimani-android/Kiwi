package com.kiwi.android.home.model

data class UiFlight(
    val id: String,
    val cityFrom: String,
    val cityTo: String,
    val countryFrom: UiCountry,
    val countryTo: UiCountry,
    val distance: Int,
    val popularity: Long,
    val flyDuration: String,
    val availability: UiFlyAvailability,
    val destinationImagePath: String
)

data class UiCountry(
    val code: String,
    val name: String
)

data class UiFlyAvailability(
    val seats: Int
)