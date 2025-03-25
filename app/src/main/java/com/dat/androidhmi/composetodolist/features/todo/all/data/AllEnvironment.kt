package com.dat.androidhmi.composetodolist.features.todo.all.data

import com.dat.androidhmi.composetodolist.foundation.datasource.local.provider.ToDoListProvider
import com.dat.androidhmi.composetodolist.foundation.datasource.local.provider.ToDoTaskProvider
import com.dat.androidhmi.composetodolist.foundation.extension.toggleStatusHandler
import com.dat.androidhmi.composetodolist.foundation.wrapper.DateTimeProvider
import com.dat.androidhmi.composetodolist.model.ToDoList
import com.dat.androidhmi.composetodolist.model.ToDoTask
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AllEnvironment @Inject constructor(
    override val dateTimeProvider: DateTimeProvider,
    private val toDoListProvider: ToDoListProvider,
    private val toDoTaskProvider: ToDoTaskProvider
) : IAllEnvironment {

    override fun getList(): Flow<List<ToDoList>> {
        return toDoListProvider.getListWithTasks()
    }

    override suspend fun toggleTaskStatus(toDoTask: ToDoTask) {
        val currentDate = dateTimeProvider.now()
        toDoTask.toggleStatusHandler(
            currentDate,
            { completedAt, newStatus ->
                toDoTaskProvider.updateTaskStatus(toDoTask.id, newStatus, completedAt, currentDate)
            },
            { nextDueDate ->
                toDoTaskProvider.updateTaskDueDate(toDoTask.id, nextDueDate, toDoTask.isDueDateTimeSet, currentDate)
            }
        )
    }

    override suspend fun deleteTask(task: ToDoTask) {
        toDoTaskProvider.deleteTaskById(task.id)
    }

}
