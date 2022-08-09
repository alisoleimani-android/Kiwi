package com.kiwi.android.ui.model

interface UiMapper<E, V> {
    fun mapToView(domainEntity: E): V
}