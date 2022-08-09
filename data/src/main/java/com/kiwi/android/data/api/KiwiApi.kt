package com.kiwi.android.data.api

import com.kiwi.android.data.api.ApiConstants.FLIGHTS_ENDPOINT
import com.kiwi.android.data.api.ApiParameters.PARAM_DATE_FROM
import com.kiwi.android.data.api.ApiParameters.PARAM_FLY_FROM
import com.kiwi.android.data.api.ApiParameters.PARAM_LIMIT
import com.kiwi.android.data.api.ApiParameters.PARAM_SORT
import com.kiwi.android.data.api.model.ApiFlight
import com.kiwi.android.data.api.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface KiwiApi {

    @GET(FLIGHTS_ENDPOINT)
    suspend fun getFlights(
        @Query(PARAM_SORT) sort: String = "popularity",
        @Query(PARAM_FLY_FROM) flyFrom: String = "prague_cz",
        @Query(PARAM_LIMIT) limit: Int = 50,
        @Query(PARAM_DATE_FROM) dateFrom: String,
    ): ApiResponse<List<ApiFlight>>

}