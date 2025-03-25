package com.dat.androidhmi.composetodolist.foundation.extension

import com.dat.androidhmi.composetodolist.foundation.datasource.preference.mapper.toThemePreference
import com.dat.androidhmi.composetodolist.foundation.datasource.preference.model.ThemePreference
import com.dat.androidhmi.composetodolist.model.Theme
import org.junit.Assert
import org.junit.Test

class ThemeExtTest {
    @Test
    fun mapToPreference() {
        Assert.assertEquals(ThemePreference.SYSTEM, Theme.SYSTEM.toThemePreference())
        Assert.assertEquals(ThemePreference.LIGHT, Theme.LIGHT.toThemePreference())
        Assert.assertEquals(ThemePreference.NIGHT, Theme.NIGHT.toThemePreference())
        Assert.assertEquals(ThemePreference.AURORA, Theme.AURORA.toThemePreference())
        Assert.assertEquals(ThemePreference.TWILIGHT, Theme.TWILIGHT.toThemePreference())
        Assert.assertEquals(ThemePreference.SUNRISE, Theme.SUNRISE.toThemePreference())
    }
}
