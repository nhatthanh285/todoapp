package com.dat.androidhmi.composetodolist.foundation.extension

import com.dat.androidhmi.composetodolist.model.ToDoStatus

fun ToDoStatus.toggle(): ToDoStatus {
    return when (this) {
        ToDoStatus.IN_PROGRESS -> ToDoStatus.COMPLETE
        ToDoStatus.COMPLETE -> ToDoStatus.IN_PROGRESS
    }
}
