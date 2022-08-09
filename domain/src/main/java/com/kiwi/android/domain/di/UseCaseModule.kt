package com.kiwi.android.domain.di

import com.kiwi.android.domain.usecase.GetFlights
import com.kiwi.android.domain.usecase.RequestUpdateSuggestions
import com.kiwi.android.domain.usecase.impl.GetFlightsImpl
import com.kiwi.android.domain.usecase.impl.RequestUpdateSuggestionsImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Suppress("unused")
@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun bindGetFlights(impl: GetFlightsImpl): GetFlights

    @Binds
    abstract fun bindRequestUpdateSuggestions(impl: RequestUpdateSuggestionsImpl): RequestUpdateSuggestions
}