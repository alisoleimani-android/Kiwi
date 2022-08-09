package com.kiwi.android.data.api.model.mapper

import com.kiwi.android.data.api.model.ApiCountry
import com.kiwi.android.data.api.model.ApiFlight
import com.kiwi.android.data.api.model.ApiFlyAvailability
import com.kiwi.android.domain.model.Country
import com.kiwi.android.domain.model.Flight
import com.kiwi.android.domain.model.FlyAvailability
import javax.inject.Inject

class ApiFlightMapper @Inject constructor(
    private val apiCountryMapper: ApiCountryMapper,
    private val apiFlyAvailabilityMapper: ApiFlyAvailabilityMapper
) : ApiMapper<ApiFlight, Flight> {

    override fun mapToDomain(apiEntity: ApiFlight): Flight {
        return Flight(
            id = apiEntity.id,
            cityFrom = apiEntity.cityFrom.orEmpty(),
            cityTo = apiEntity.cityTo.orEmpty(),
            countryFrom = apiCountryMapper.mapToDomain(apiEntity.countryFrom),
            countryTo = apiCountryMapper.mapToDomain(apiEntity.countryTo),
            distance = apiEntity.distance ?: 0.00,
            popularity = apiEntity.popularity ?: 0,
            flyDuration = apiEntity.flyDuration.orEmpty(),
            availability = apiFlyAvailabilityMapper.mapToDomain(apiEntity.availability),
            destinationId = apiEntity.destinationId.orEmpty()
        )
    }
}

class ApiCountryMapper @Inject constructor() : ApiMapper<ApiCountry, Country> {
    override fun mapToDomain(apiEntity: ApiCountry): Country {
        return Country(
            code = apiEntity.code.orEmpty(),
            name = apiEntity.name.orEmpty()
        )
    }
}

class ApiFlyAvailabilityMapper @Inject constructor() :
    ApiMapper<ApiFlyAvailability, FlyAvailability> {
    override fun mapToDomain(apiEntity: ApiFlyAvailability): FlyAvailability {
        return FlyAvailability(seats = apiEntity.seats ?: 0)
    }
}