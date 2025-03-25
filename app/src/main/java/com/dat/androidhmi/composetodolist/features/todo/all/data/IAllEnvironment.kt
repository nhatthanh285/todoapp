package com.dat.androidhmi.composetodolist.features.todo.all.data

import com.dat.androidhmi.composetodolist.foundation.wrapper.DateTimeProvider
import com.dat.androidhmi.composetodolist.model.ToDoList
import com.dat.androidhmi.composetodolist.model.ToDoTask
import kotlinx.coroutines.flow.Flow

interface IAllEnvironment {
    val dateTimeProvider: DateTimeProvider
    fun getList(): Flow<List<ToDoList>>
    suspend fun toggleTaskStatus(toDoTask: ToDoTask)
    suspend fun deleteTask(task: ToDoTask)
}
