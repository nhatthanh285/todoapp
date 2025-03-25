package com.dat.androidhmi.composetodolist.features.theme.data

import com.dat.androidhmi.composetodolist.foundation.datasource.preference.provider.ThemeProvider
import com.dat.androidhmi.composetodolist.model.Theme
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ThemeEnvironment @Inject constructor(
    private val themeProvider: ThemeProvider
) : IThemeEnvironment {

    override fun getTheme(): Flow<Theme> {
        return themeProvider.getTheme()
    }

    override suspend fun setTheme(theme: Theme) {
        themeProvider.setTheme(theme)
    }

}
