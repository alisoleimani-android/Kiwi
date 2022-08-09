package com.kiwi.android.appinitializers

import android.app.Application
import com.kiwi.android.BuildConfig
import com.kiwi.android.core.KiwiLogger
import javax.inject.Inject

class TimberInitializer @Inject constructor(
    private val logger: KiwiLogger
) : Initializer {
    override fun init(application: Application) = logger.setup(BuildConfig.DEBUG)
}
