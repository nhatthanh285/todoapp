package com.dat.androidhmi.composetodolist.features.todo.main.data

import com.dat.androidhmi.composetodolist.foundation.datasource.local.provider.ToDoGroupProvider
import com.dat.androidhmi.composetodolist.foundation.datasource.local.provider.ToDoListProvider
import com.dat.androidhmi.composetodolist.foundation.datasource.local.provider.ToDoTaskProvider
import com.dat.androidhmi.composetodolist.foundation.wrapper.DateTimeProvider
import com.dat.androidhmi.composetodolist.model.ToDoGroup
import com.dat.androidhmi.composetodolist.model.ToDoList
import com.dat.androidhmi.composetodolist.model.ToDoTaskOverallCount
import kotlinx.coroutines.flow.Flow
import java.time.LocalDateTime
import java.time.LocalTime
import javax.inject.Inject

class ToDoMainEnvironment @Inject constructor(
    override val dateTimeProvider: DateTimeProvider,
    private val toDoGroupProvider: ToDoGroupProvider,
    private val toDoListProvider: ToDoListProvider,
    private val toDoTaskProvider: ToDoTaskProvider,
) : IToDoMainEnvironment {

    override fun getGroup(): Flow<List<ToDoGroup>> {
        return toDoGroupProvider.getGroupWithList()
    }

    override fun getOverallCount(): Flow<ToDoTaskOverallCount> {
        val tomorrow = LocalDateTime.of(dateTimeProvider.now().toLocalDate().plusDays(1), LocalTime.MIN)
        return toDoTaskProvider.getOverallCount(tomorrow)
    }

    override suspend fun deleteList(list: ToDoList) {
        toDoListProvider.deleteListById(list.id)
    }

}
