package com.dat.androidhmi.composetodolist.foundation.di

import com.dat.androidhmi.composetodolist.foundation.wrapper.DateTimeProvider
import com.dat.androidhmi.composetodolist.foundation.wrapper.DateTimeProviderImpl
import com.dat.androidhmi.composetodolist.foundation.wrapper.IdProvider
import com.dat.androidhmi.composetodolist.foundation.wrapper.IdProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CommonModule {

    @Singleton
    @Provides
    fun provideIdProvider(): IdProvider {
        return IdProviderImpl()
    }

    @Singleton
    @Provides
    fun provideDateTimeProvider(): DateTimeProvider {
        return DateTimeProviderImpl()
    }

}
