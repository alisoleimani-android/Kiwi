package com.kiwi.android.home

import com.kiwi.android.domain.repository.AppRepository
import com.kiwi.android.domain.usecase.impl.RequestUpdateSuggestionsImpl
import com.kiwi.android.home.model.UiCountryMapper
import com.kiwi.android.home.model.UiFlightMapper
import com.kiwi.android.home.model.UiFlyAvailabilityMapper
import com.kiwi.common.test.CoroutineRule
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class HomeViewModelIntegrationTest {

    @get:Rule
    val coroutineRule = CoroutineRule()

    // UI mappers
    private val uiCountryMapper = UiCountryMapper()
    private val uiAvailabilityMapper = UiFlyAvailabilityMapper()
    private val uiFlightMapper = UiFlightMapper(uiCountryMapper, uiAvailabilityMapper)

    @Test
    fun `Calling updateSuggestions() triggers API after ViewModel is created`() = runTest {
        val mockAppRepository: AppRepository = mockk(relaxed = true)

        // Arrange
        coEvery { mockAppRepository.requestGetFlights(any()) } returns Result.success(listOf())

        HomeViewModel(
            getFlights = mockk(relaxed = true),
            requestUpdateSuggestions = RequestUpdateSuggestionsImpl(
                repository = mockAppRepository,
                preferences = mockk(relaxed = true)
            ),
            uiFlightMapper = uiFlightMapper
        )

        // Act
        runCurrent()

        // Assert
        coVerify { mockAppRepository.requestGetFlights(any()) }
        confirmVerified(mockAppRepository)
    }
}