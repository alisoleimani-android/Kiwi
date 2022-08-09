package com.kiwi.android.domain.model

import java.io.IOException

class NetworkUnavailableException(
    message: String = "No network available"
) : IOException(message)

class NetworkException(message: String) : Exception(message)