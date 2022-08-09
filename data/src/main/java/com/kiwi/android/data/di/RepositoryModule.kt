package com.kiwi.android.data.di

import com.kiwi.android.data.repository.AppRepositoryImpl
import com.kiwi.android.domain.repository.AppRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Suppress("unused")
@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class RepositoryModule {

    @Binds
    @ActivityRetainedScoped
    abstract fun bindAppRepository(repository: AppRepositoryImpl): AppRepository
}