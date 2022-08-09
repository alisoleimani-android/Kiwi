package com.kiwi.android.domain.usecase.impl

import com.kiwi.android.domain.model.Flight
import com.kiwi.android.domain.repository.AppRepository
import com.kiwi.android.domain.usecase.GetFlights
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import javax.inject.Inject

class GetFlightsImpl @Inject constructor(
    private val repository: AppRepository
) : GetFlights {
    override fun invoke(): Flow<List<Flight>> {
        return repository.getFlightsFlowable().filter { it.isNotEmpty() }
    }
}