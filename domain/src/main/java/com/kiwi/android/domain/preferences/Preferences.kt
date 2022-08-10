package com.kiwi.android.domain.preferences

import com.kiwi.android.core.Theme
import kotlinx.coroutines.flow.Flow

interface Preferences {

    var theme: Theme

    fun setup()

    fun observeTheme(): Flow<Theme>

    fun putSuggestionsExpiration(expirationTime: Long)

    fun getSuggestionsExpiration(): Long

}