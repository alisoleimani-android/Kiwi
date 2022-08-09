package com.kiwi.android.data.api.model.mapper

interface ApiMapper<E, D> {

    fun mapToDomain(apiEntity: E): D
}