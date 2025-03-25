package com.dat.androidhmi.composetodolist.features.dashboard.di

import com.dat.androidhmi.composetodolist.features.dashboard.data.DashboardEnvironment
import com.dat.androidhmi.composetodolist.features.dashboard.data.IDashboardEnvironment
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DashboardModule {

    @Binds
    abstract fun provideEnvironment(
        environment: DashboardEnvironment
    ): IDashboardEnvironment

}
