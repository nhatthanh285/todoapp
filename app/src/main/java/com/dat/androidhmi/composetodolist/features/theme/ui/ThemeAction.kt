package com.dat.androidhmi.composetodolist.features.theme.ui

sealed class ThemeAction {
    data class SelectTheme(val selected: ThemeItem) : ThemeAction()
}
