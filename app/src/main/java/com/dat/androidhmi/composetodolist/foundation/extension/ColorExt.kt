package com.dat.androidhmi.composetodolist.foundation.extension

import androidx.compose.ui.graphics.Color
import com.dat.androidhmi.composetodolist.foundation.theme.ListBlue
import com.dat.androidhmi.composetodolist.foundation.theme.ListBrown
import com.dat.androidhmi.composetodolist.foundation.theme.ListGreen
import com.dat.androidhmi.composetodolist.foundation.theme.ListOrange
import com.dat.androidhmi.composetodolist.foundation.theme.ListPurple
import com.dat.androidhmi.composetodolist.foundation.theme.ListRed
import com.dat.androidhmi.composetodolist.foundation.theme.ListYellow
import com.dat.androidhmi.composetodolist.model.ToDoColor

fun ToDoColor.toColor() = when (this) {
    ToDoColor.BLUE -> ListBlue
    ToDoColor.RED -> ListRed
    ToDoColor.GREEN -> ListGreen
    ToDoColor.YELLOW -> ListYellow
    ToDoColor.ORANGE -> ListOrange
    ToDoColor.PURPLE -> ListPurple
    ToDoColor.BROWN -> ListBrown
}

fun Color.toToDoColor() = when (this) {
    ListRed -> ToDoColor.RED
    ListGreen -> ToDoColor.GREEN
    ListYellow -> ToDoColor.YELLOW
    ListOrange -> ToDoColor.ORANGE
    ListPurple -> ToDoColor.PURPLE
    ListBrown -> ToDoColor.BROWN
    else -> ToDoColor.BLUE
}

