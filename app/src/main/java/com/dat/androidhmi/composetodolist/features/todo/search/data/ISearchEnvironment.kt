package com.dat.androidhmi.composetodolist.features.todo.search.data

import com.dat.androidhmi.composetodolist.model.ToDoList
import com.dat.androidhmi.composetodolist.model.ToDoTask
import kotlinx.coroutines.flow.Flow

interface ISearchEnvironment {
    fun searchList(query: String): Flow<List<ToDoList>>
    suspend fun toggleTaskStatus(toDoTask: ToDoTask)
    suspend fun deleteTask(task: ToDoTask)
}
