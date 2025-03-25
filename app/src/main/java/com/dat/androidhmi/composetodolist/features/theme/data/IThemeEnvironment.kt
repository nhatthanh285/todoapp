package com.dat.androidhmi.composetodolist.features.theme.data

import com.dat.androidhmi.composetodolist.model.Theme
import kotlinx.coroutines.flow.Flow

interface IThemeEnvironment {
    fun getTheme(): Flow<Theme>
    suspend fun setTheme(theme: Theme)
}
