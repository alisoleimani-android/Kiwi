package com.kiwi.android.appinitializers

import android.app.Application

interface Initializer {
    fun init(application: Application)
}
