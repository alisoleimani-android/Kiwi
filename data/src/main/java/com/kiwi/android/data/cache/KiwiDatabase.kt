package com.kiwi.android.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kiwi.android.data.cache.dao.FlightsDao
import com.kiwi.android.data.cache.model.CachedAvailability
import com.kiwi.android.data.cache.model.CachedCountry
import com.kiwi.android.data.cache.model.CachedFlight

@Database(
    entities = [
        CachedFlight::class,
        CachedCountry::class,
        CachedAvailability::class
    ],
    version = 1
)
abstract class KiwiDatabase : RoomDatabase() {
    abstract fun flightsDao(): FlightsDao
}