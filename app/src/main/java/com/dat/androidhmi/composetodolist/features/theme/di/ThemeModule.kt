package com.dat.androidhmi.composetodolist.features.theme.di

import com.dat.androidhmi.composetodolist.features.theme.data.IThemeEnvironment
import com.dat.androidhmi.composetodolist.features.theme.data.ThemeEnvironment
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class ThemeModule {

    @Binds
    abstract fun provideEnvironment(
        environment: ThemeEnvironment
    ): IThemeEnvironment

}
