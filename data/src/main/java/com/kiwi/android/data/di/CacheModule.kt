package com.kiwi.android.data.di

import android.content.Context
import androidx.room.Room
import com.kiwi.android.data.cache.Cache
import com.kiwi.android.data.cache.KiwiDatabase
import com.kiwi.android.data.cache.RoomCache
import com.kiwi.android.data.cache.dao.FlightsDao
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CacheModule {

    @Binds
    abstract fun bindCache(cache: RoomCache): Cache

    companion object {

        @Provides
        @Singleton
        fun provideDatabase(
            @ApplicationContext context: Context
        ): KiwiDatabase {
            return Room.databaseBuilder(context, KiwiDatabase::class.java, "kiwicom.db").build()
        }

        @Provides
        fun provideFlightsDao(database: KiwiDatabase): FlightsDao = database.flightsDao()
    }
}