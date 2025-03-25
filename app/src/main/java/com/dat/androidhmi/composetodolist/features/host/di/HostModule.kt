package com.dat.androidhmi.composetodolist.features.host.di

import com.dat.androidhmi.composetodolist.features.host.data.HostEnvironment
import com.dat.androidhmi.composetodolist.features.host.data.IHostEnvironment
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class HostModule {

    @Binds
    abstract fun provideEnvironment(
        environment: HostEnvironment
    ): IHostEnvironment

}
