package com.dat.androidhmi.composetodolist.foundation.extension

import com.dat.androidhmi.composetodolist.R
import com.dat.androidhmi.composetodolist.model.ToDoRepeat

fun ToDoRepeat.displayable(): Int {
    return when (this) {
        ToDoRepeat.NEVER -> R.string.todo_repeat_never
        ToDoRepeat.DAILY -> R.string.todo_repeat_daily
        ToDoRepeat.WEEKDAYS -> R.string.todo_repeat_weekdays
        ToDoRepeat.WEEKLY -> R.string.todo_repeat_weekly
        ToDoRepeat.MONTHLY -> R.string.todo_repeat_monthly
        ToDoRepeat.YEARLY -> R.string.todo_repeat_yearly
    }
}
