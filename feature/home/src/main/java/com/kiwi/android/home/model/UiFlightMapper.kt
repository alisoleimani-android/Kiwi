package com.kiwi.android.home.model

import com.kiwi.android.domain.model.Country
import com.kiwi.android.domain.model.Flight
import com.kiwi.android.domain.model.FlyAvailability
import com.kiwi.android.ui.BuildConfig
import com.kiwi.android.ui.model.UiMapper
import javax.inject.Inject

class UiFlightMapper @Inject constructor(
    private val uiCountryMapper: UiCountryMapper,
    private val availabilityMapper: UiFlyAvailabilityMapper
) : UiMapper<Flight, UiFlight> {

    override fun mapToView(domainEntity: Flight): UiFlight {
        return UiFlight(
            id = domainEntity.id,
            cityFrom = domainEntity.cityFrom,
            cityTo = domainEntity.cityTo,
            countryFrom = uiCountryMapper.mapToView(domainEntity.countryFrom),
            countryTo = uiCountryMapper.mapToView(domainEntity.countryTo),
            distance = domainEntity.distance,
            popularity = domainEntity.popularity,
            flyDuration = domainEntity.flyDuration,
            availability = availabilityMapper.mapToView(domainEntity.availability),
            destinationImagePath = "${BuildConfig.IMAGE_BASE_URL}${domainEntity.destinationId}.jpg"
        )
    }
}

class UiCountryMapper @Inject constructor() : UiMapper<Country, UiCountry> {
    override fun mapToView(domainEntity: Country): UiCountry {
        return UiCountry(code = domainEntity.code, name = domainEntity.name)
    }
}

class UiFlyAvailabilityMapper @Inject constructor() : UiMapper<FlyAvailability, UiFlyAvailability> {
    override fun mapToView(domainEntity: FlyAvailability): UiFlyAvailability {
        return UiFlyAvailability(seats = domainEntity.seats)
    }
}