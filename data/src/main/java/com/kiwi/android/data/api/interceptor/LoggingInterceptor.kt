package com.kiwi.android.data.api.interceptor

import com.kiwi.android.core.Logger
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Inject

class LoggingInterceptor @Inject constructor(
    private val logger: Logger
) : HttpLoggingInterceptor.Logger {
    override fun log(message: String) {
        logger.i(message)
    }
}