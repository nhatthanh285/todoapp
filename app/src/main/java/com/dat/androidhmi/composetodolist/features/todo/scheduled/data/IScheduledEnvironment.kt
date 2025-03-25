package com.dat.androidhmi.composetodolist.features.todo.scheduled.data

import com.dat.androidhmi.composetodolist.foundation.wrapper.DateTimeProvider
import com.dat.androidhmi.composetodolist.foundation.wrapper.IdProvider
import com.dat.androidhmi.composetodolist.model.TaskWithList
import com.dat.androidhmi.composetodolist.model.ToDoTask
import kotlinx.coroutines.flow.Flow
import java.time.LocalDateTime

interface IScheduledEnvironment {
    val idProvider: IdProvider
    val dateTimeProvider: DateTimeProvider
    fun getToDoTaskWithStepsOrderByDueDateWithList(maxDate: LocalDateTime? = null): Flow<List<TaskWithList>>
    suspend fun toggleTaskStatus(toDoTask: ToDoTask)
    suspend fun deleteTask(task: ToDoTask)
}
