package com.dat.androidhmi.composetodolist.features.host.data

import com.dat.androidhmi.composetodolist.model.Theme
import kotlinx.coroutines.flow.Flow

interface IHostEnvironment {
    fun getTheme(): Flow<Theme>
}
