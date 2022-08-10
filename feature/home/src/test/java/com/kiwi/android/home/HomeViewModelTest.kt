package com.kiwi.android.home

import com.google.common.truth.Truth.assertThat
import com.kiwi.android.domain.usecase.GetFlights
import com.kiwi.android.domain.usecase.RequestUpdateSuggestions
import com.kiwi.android.home.model.UiCountryMapper
import com.kiwi.android.home.model.UiFlightMapper
import com.kiwi.android.home.model.UiFlyAvailabilityMapper
import com.kiwi.common.test.CoroutineRule
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class HomeViewModelTest {

    @get:Rule
    val coroutineRule = CoroutineRule()

    // Mocked use-cases
    private val mockGetFlights: GetFlights = mockk(relaxed = true)
    private val mockRequestUpdateSuggestions: RequestUpdateSuggestions = mockk(relaxed = true)

    // UI mappers
    private val uiCountryMapper = UiCountryMapper()
    private val uiAvailabilityMapper = UiFlyAvailabilityMapper()
    private val uiFlightMapper = UiFlightMapper(uiCountryMapper, uiAvailabilityMapper)

    @Test
    fun `Creating the ViewModel loads suggested flights`() = runTest {
        // Arrange
        val dataFromUseCase = listOf(fakeFlight1)
        coEvery { mockGetFlights.invoke() } returns flowOf(dataFromUseCase)

        val viewModel = HomeViewModel(
            getFlights = mockGetFlights,
            requestUpdateSuggestions = mockRequestUpdateSuggestions,
            uiFlightMapper = uiFlightMapper
        )

        val expectedUiState = HomeUiState(
            suggestedFlights = dataFromUseCase.map { uiFlightMapper.mapToView(it) }
        )

        // Act
        runCurrent() // Runs subscribeToFlightUpdates within init block of ViewModel

        // Assert
        val actualUiState = viewModel.uiState.value
        assertThat(actualUiState).isEqualTo(expectedUiState)
    }

}