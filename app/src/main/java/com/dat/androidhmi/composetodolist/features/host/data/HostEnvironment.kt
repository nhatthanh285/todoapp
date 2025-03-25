package com.dat.androidhmi.composetodolist.features.host.data

import com.dat.androidhmi.composetodolist.foundation.datasource.preference.provider.ThemeProvider
import com.dat.androidhmi.composetodolist.model.Theme
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HostEnvironment @Inject constructor(
    private val themeProvider: ThemeProvider
) : IHostEnvironment {

    override fun getTheme(): Flow<Theme> {
        return themeProvider.getTheme()
    }

}
