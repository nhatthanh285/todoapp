package com.dat.androidhmi.composetodolist.runtime.navigation

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Shape
import com.dat.androidhmi.composetodolist.foundation.theme.LargeRadius
import com.dat.androidhmi.composetodolist.foundation.theme.SmallRadius

@Immutable
data class MainBottomSheetConfig(
    val sheetShape: Shape,
    val showScrim: Boolean
)

val DefaultMainBottomSheetConfig = MainBottomSheetConfig(
    RoundedCornerShape(
        topStart = LargeRadius,
        topEnd = LargeRadius
    ),
    true
)
val NoScrimMainBottomSheetConfig = MainBottomSheetConfig(
    RoundedCornerShape(
        topStart = LargeRadius,
        topEnd = LargeRadius
    ),
    false
)
val NoScrimSmallShapeMainBottomSheetConfig = MainBottomSheetConfig(
    RoundedCornerShape(
        topStart = SmallRadius,
        topEnd = SmallRadius
    ),
    false
)

