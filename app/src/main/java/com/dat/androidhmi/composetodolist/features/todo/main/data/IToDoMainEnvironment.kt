package com.dat.androidhmi.composetodolist.features.todo.main.data

import com.dat.androidhmi.composetodolist.foundation.wrapper.DateTimeProvider
import com.dat.androidhmi.composetodolist.model.ToDoGroup
import com.dat.androidhmi.composetodolist.model.ToDoList
import com.dat.androidhmi.composetodolist.model.ToDoTaskOverallCount
import kotlinx.coroutines.flow.Flow

interface IToDoMainEnvironment {
    val dateTimeProvider: DateTimeProvider
    fun getGroup(): Flow<List<ToDoGroup>>
    fun getOverallCount(): Flow<ToDoTaskOverallCount>
    suspend fun deleteList(list: ToDoList)
}
