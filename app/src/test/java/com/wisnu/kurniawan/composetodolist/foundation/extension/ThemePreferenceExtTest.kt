package com.dat.androidhmi.composetodolist.foundation.extension

import com.dat.androidhmi.composetodolist.foundation.datasource.preference.mapper.toTheme
import com.dat.androidhmi.composetodolist.foundation.datasource.preference.model.ThemePreference
import com.dat.androidhmi.composetodolist.model.Theme
import org.junit.Assert
import org.junit.Test

class ThemePreferenceExtTest {

    @Test
    fun mapToTheme() {
        Assert.assertEquals(Theme.SYSTEM, ThemePreference.SYSTEM.toTheme())
        Assert.assertEquals(Theme.LIGHT, ThemePreference.LIGHT.toTheme())
        Assert.assertEquals(Theme.NIGHT, ThemePreference.NIGHT.toTheme())
        Assert.assertEquals(Theme.TWILIGHT, ThemePreference.TWILIGHT.toTheme())
        Assert.assertEquals(Theme.AURORA, ThemePreference.AURORA.toTheme())
        Assert.assertEquals(Theme.SUNRISE, ThemePreference.SUNRISE.toTheme())
    }

}
