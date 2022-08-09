package com.kiwi.android.domain.usecase.impl

import com.kiwi.android.domain.model.Flight
import com.kiwi.android.domain.preferences.Preferences
import com.kiwi.android.domain.repository.AppRepository
import com.kiwi.android.domain.usecase.RequestUpdateSuggestions
import kotlinx.datetime.*
import javax.inject.Inject

class RequestUpdateSuggestionsImpl @Inject constructor(
    private val repository: AppRepository,
    private val preferences: Preferences
) : RequestUpdateSuggestions {

    override suspend fun invoke() {
        if (areSuggestionsExpired()) {
            val dateFrom = Clock.System.now()
                .toLocalDateTime(TimeZone.currentSystemDefault())
                .date.toString()

            val result = repository.requestGetFlights(dateFrom)

            if (result.isSuccess) {
                updateCachedFlights(result.getOrNull().orEmpty())
            }
        }
    }

    private suspend fun updateCachedFlights(flights: List<Flight>) {
        if (flights.isEmpty()) return

        // Read cached flight form table
        val cachedFlights = repository.getFlights()

        // Remove cached items from response
        val subtractedList = flights.subtract(cachedFlights.toSet()).toList()

        // Shuffle and take five of them
        val shuffledList = subtractedList.shuffled().take(5)

        // Clear table
        repository.deleteFlights()

        // Store shuffled list
        repository.storeFlights(shuffledList)

        // Store new expiration for suggestions on preferences
        updateSuggestionsExpiration()
    }

    private fun areSuggestionsExpired(): Boolean {
        val now = Clock.System.now()
        val expirationTime = Instant.fromEpochSeconds(preferences.getSuggestionsExpiration())
        return now >= expirationTime
    }

    private fun updateSuggestionsExpiration() {
        val now = Clock.System.now()
        val systemTZ = TimeZone.currentSystemDefault()
        val fiveDaysLater = now.plus(1, DateTimeUnit.DAY, systemTZ)
        preferences.putSuggestionsExpiration(fiveDaysLater.epochSeconds)
    }
}