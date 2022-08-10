package com.kiwi.android.data.preferences

import android.content.Context
import android.content.SharedPreferences
import com.kiwi.android.core.Theme
import com.kiwi.android.data.preferences.PreferencesConstants.KEY_SUGGESTIONS_EXPIRATION
import com.kiwi.android.data.preferences.PreferencesConstants.KEY_THEME
import com.kiwi.android.domain.preferences.Preferences
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppPreferences @Inject constructor(
    @ApplicationContext context: Context
) : Preferences {

    companion object {
        const val PREFERENCES_NAME = "KIWI_PREFERENCES"
    }

    private val defaultThemeValue = Theme.DARK.value

    private val preferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)

    private val preferenceKeyChangedFlow = MutableSharedFlow<String>(extraBufferCapacity = 1)

    private val listener = SharedPreferences.OnSharedPreferenceChangeListener { _, key ->
        preferenceKeyChangedFlow.tryEmit(key)
    }

    override var theme: Theme
        get() = getThemeForStorageKey(preferences.getString(KEY_THEME, defaultThemeValue).orEmpty())
        set(value) = edit { putString(KEY_THEME, value.value) }

    override fun setup() {
        preferences.registerOnSharedPreferenceChangeListener(listener)
    }

    override fun putSuggestionsExpiration(expirationTime: Long) {
        edit { putLong(KEY_SUGGESTIONS_EXPIRATION, expirationTime) }
    }

    override fun getSuggestionsExpiration(): Long {
        return preferences.getLong(KEY_SUGGESTIONS_EXPIRATION, -1)
    }

    override fun observeTheme(): Flow<Theme> {
        return preferenceKeyChangedFlow
            // Emit on start so that we always send the initial value
            .onStart { emit(KEY_THEME) }
            .filter { it == KEY_THEME }
            .map { theme }
            .distinctUntilChanged()
    }

    private fun getThemeForStorageKey(value: String) =
        when (value) {
            Theme.DARK.value -> {
                Theme.DARK
            }
            else -> {
                Theme.LIGHT
            }
        }

    private inline fun edit(block: SharedPreferences.Editor.() -> Unit) {
        with(preferences.edit()) {
            block()
            commit()
        }
    }
}