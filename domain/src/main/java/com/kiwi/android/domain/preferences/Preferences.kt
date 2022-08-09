package com.kiwi.android.domain.preferences

interface Preferences {

    fun putSuggestionsExpiration(expirationTime: Long)

    fun getSuggestionsExpiration(): Long

}