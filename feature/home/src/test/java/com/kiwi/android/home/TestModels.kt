package com.kiwi.android.home

import com.kiwi.android.domain.model.Country
import com.kiwi.android.domain.model.Flight
import com.kiwi.android.domain.model.FlyAvailability

val fakeFlight1 = Flight(
    id = "id1",
    cityFrom = "Paris",
    cityTo = "Milan",
    countryFrom = Country(code = "c1", name = "France"),
    countryTo = Country(code = "c2", name = "Italy"),
    distance = 1000.0,
    popularity = 10,
    flyDuration = "1h 20m",
    availability = FlyAvailability(seats = 5),
    destinationId = "milan_it"
)