package com.dat.androidhmi.composetodolist.model

data class ToDoTaskDiff(
    val addedTask: Map<String, ToDoTask>,
    val deletedTask: Map<String, ToDoTask>,
    val modifiedTask: Map<String, ToDoTask>,
)
