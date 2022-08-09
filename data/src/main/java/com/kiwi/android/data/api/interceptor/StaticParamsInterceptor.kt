package com.kiwi.android.data.api.interceptor

import com.kiwi.android.data.api.ApiParameters.PARAM_API_VERSION
import com.kiwi.android.data.api.ApiParameters.PARAM_LOCALE
import com.kiwi.android.data.api.ApiParameters.PARAM_PARTNER
import okhttp3.Interceptor
import okhttp3.Response
import java.util.*
import javax.inject.Inject

class StaticParamsInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url

        val url = originalHttpUrl.newBuilder()
            .addQueryParameter(PARAM_API_VERSION, "3")
            .addQueryParameter(PARAM_PARTNER, "skypicker-android")
            .addQueryParameter(PARAM_LOCALE, Locale.getDefault().language)
            .build()

        val reqBuilder = original.newBuilder()
            .url(url)
        return chain.proceed(reqBuilder.build())
    }

}