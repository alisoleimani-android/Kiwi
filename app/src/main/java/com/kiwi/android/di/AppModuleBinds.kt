package com.kiwi.android.di

import com.kiwi.android.appinitializers.Initializer
import com.kiwi.android.appinitializers.TimberInitializer
import com.kiwi.android.core.CoroutineDispatchersProvider
import com.kiwi.android.core.DispatchersProvider
import com.kiwi.android.core.KiwiLogger
import com.kiwi.android.core.Logger
import com.kiwi.android.data.api.ConnectionManager
import com.kiwi.android.data.api.ConnectionManagerImpl
import com.kiwi.android.data.preferences.AppPreferences
import com.kiwi.android.domain.preferences.Preferences
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import javax.inject.Singleton

@Suppress("unused")
@InstallIn(SingletonComponent::class)
@Module
abstract class AppModuleBinds {

    @Singleton
    @Binds
    abstract fun provideLogger(bind: KiwiLogger): Logger

    @Binds
    @IntoSet
    abstract fun provideTimberInitializer(bind: TimberInitializer): Initializer

    @Binds
    abstract fun bindDispatchersProvider(provider: CoroutineDispatchersProvider): DispatchersProvider

    @Binds
    abstract fun bindConnectionManager(manager: ConnectionManagerImpl): ConnectionManager

    @Singleton
    @Binds
    abstract fun bindAppPreferences(preferences: AppPreferences): Preferences

}
