package com.dat.androidhmi.composetodolist.features.theme.ui

import android.os.Build
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewModelScope
import com.wisnu.foundation.coreviewmodel.StatefulViewModel
import com.dat.androidhmi.composetodolist.R
import com.dat.androidhmi.composetodolist.features.theme.data.IThemeEnvironment
import com.dat.androidhmi.composetodolist.foundation.theme.AuroraItemBackgroundL2
import com.dat.androidhmi.composetodolist.foundation.theme.AuroraPrimary
import com.dat.androidhmi.composetodolist.foundation.theme.LightPrimary
import com.dat.androidhmi.composetodolist.foundation.theme.NightItemBackgroundL2
import com.dat.androidhmi.composetodolist.foundation.theme.NightPrimary
import com.dat.androidhmi.composetodolist.foundation.theme.SunriseItemBackgroundL2
import com.dat.androidhmi.composetodolist.foundation.theme.SunrisePrimary
import com.dat.androidhmi.composetodolist.foundation.theme.TwilightItemBackgroundL1
import com.dat.androidhmi.composetodolist.foundation.theme.TwilightPrimary
import com.dat.androidhmi.composetodolist.model.Theme
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ThemeViewModel @Inject constructor(
    themeEnvironment: IThemeEnvironment,
) :
    StatefulViewModel<ThemeState, Unit, ThemeAction, IThemeEnvironment>(ThemeState(), themeEnvironment) {

    init {
        initTheme()
    }

    override fun dispatch(action: ThemeAction) {
        when (action) {
            is ThemeAction.SelectTheme -> applyTheme(action.selected)
        }
    }

    private fun initTheme() {
        viewModelScope.launch {
            setState { copy(items = initial()) }

            environment.getTheme()
                .collect {
                    setState { copy(items = items.select(it)) }
                }
        }
    }

    private fun applyTheme(item: ThemeItem) {
        viewModelScope.launch {
            environment.setTheme(item.theme)
        }
    }

    private fun initial(): List<ThemeItem> {
        val data = mutableListOf<ThemeItem>()

        data.add(
            ThemeItem(
                R.string.setting_theme_automatic,
                Theme.SYSTEM,
                Brush.linearGradient(
                    colors = listOf(
                        Color.White,
                        NightItemBackgroundL2
                    )
                ),
                false
            )
        )

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            data.add(
                ThemeItem(
                    R.string.setting_theme_wallpaper,
                    Theme.WALLPAPER,
                    Brush.linearGradient(
                        colors = listOf()
                    ),
                    false
                )
            )
        }

        data.add(
            ThemeItem(
                R.string.setting_theme_light,
                Theme.LIGHT,
                Brush.linearGradient(
                    colors = listOf(
                        LightPrimary,
                        Color.White
                    )
                ),
                false
            )
        )

        data.add(
            ThemeItem(
                R.string.setting_theme_twilight,
                Theme.TWILIGHT,
                Brush.linearGradient(
                    colors = listOf(
                        TwilightPrimary,
                        TwilightItemBackgroundL1
                    )
                ),
                false
            )
        )

        data.add(
            ThemeItem(
                R.string.setting_theme_night,
                Theme.NIGHT,
                Brush.linearGradient(
                    colors = listOf(
                        NightPrimary,
                        NightItemBackgroundL2
                    )
                ),
                false
            )
        )

        data.add(
            ThemeItem(
                R.string.setting_theme_sunrise,
                Theme.SUNRISE,
                Brush.linearGradient(
                    colors = listOf(
                        SunrisePrimary,
                        SunriseItemBackgroundL2
                    )
                ),
                false
            )
        )

        data.add(
            ThemeItem(
                R.string.setting_theme_aurora,
                Theme.AURORA,
                Brush.linearGradient(
                    colors = listOf(
                        AuroraPrimary,
                        AuroraItemBackgroundL2
                    )
                ),
                false
            )
        )

        return data
    }

}

fun List<ThemeItem>.select(theme: Theme): List<ThemeItem> {
    return map {
        it.copy(applied = it.theme == theme)
    }
}
