package com.kiwi.android.data.preferences

import android.content.Context
import android.content.SharedPreferences
import com.kiwi.android.data.preferences.PreferencesConstants.KEY_SUGGESTIONS_EXPIRATION
import com.kiwi.android.domain.preferences.Preferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppPreferences @Inject constructor(
    @ApplicationContext context: Context
) : Preferences {

    companion object {
        const val PREFERENCES_NAME = "KIWI_PREFERENCES"
    }

    private val preferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)

    override fun putSuggestionsExpiration(expirationTime: Long) {
        edit { putLong(KEY_SUGGESTIONS_EXPIRATION, expirationTime) }
    }

    override fun getSuggestionsExpiration(): Long {
        return preferences.getLong(KEY_SUGGESTIONS_EXPIRATION, -1)
    }

    private inline fun edit(block: SharedPreferences.Editor.() -> Unit) {
        with(preferences.edit()) {
            block()
            commit()
        }
    }
}