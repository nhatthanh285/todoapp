package com.dat.androidhmi.composetodolist.features.theme.ui

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Brush
import com.dat.androidhmi.composetodolist.model.Theme

@Immutable
data class ThemeState(
    val items: List<ThemeItem> = listOf()
)

data class ThemeItem(
    val title: Int,
    val theme: Theme,
    val brush: Brush,
    val applied: Boolean
)
