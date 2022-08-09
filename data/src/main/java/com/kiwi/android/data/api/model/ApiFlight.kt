package com.kiwi.android.data.api.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiFlight(
    val id: String,
    val cityFrom: String?,
    val cityTo: String?,
    val countryFrom: ApiCountry,
    val countryTo: ApiCountry,
    val distance: Double?,
    val popularity: Long?,
    @field:Json(name = "fly_duration") val flyDuration: String?,
    val availability: ApiFlyAvailability,
    @field:Json(name = "mapIdto") val destinationId: String?
)

@JsonClass(generateAdapter = true)
data class ApiCountry(
    val code: String?,
    val name: String?
)

@JsonClass(generateAdapter = true)
data class ApiFlyAvailability(
    val seats: Int?
)
