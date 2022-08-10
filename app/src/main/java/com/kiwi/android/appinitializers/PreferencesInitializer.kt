package com.kiwi.android.appinitializers

import android.app.Application
import com.kiwi.android.data.preferences.AppPreferences
import javax.inject.Inject

class PreferencesInitializer @Inject constructor(
    private val prefs: AppPreferences
) : Initializer {
    override fun init(application: Application) {
        prefs.setup()
    }
}
