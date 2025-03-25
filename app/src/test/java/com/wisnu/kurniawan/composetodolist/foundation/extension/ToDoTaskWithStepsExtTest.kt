package com.dat.androidhmi.composetodolist.foundation.extension

import com.dat.androidhmi.composetodolist.DateFactory
import com.dat.androidhmi.composetodolist.foundation.datasource.local.mapper.taskWithStepsToTask
import com.dat.androidhmi.composetodolist.foundation.datasource.local.model.ToDoTaskDb
import com.dat.androidhmi.composetodolist.foundation.datasource.local.model.ToDoTaskWithSteps
import com.dat.androidhmi.composetodolist.model.ToDoRepeat
import com.dat.androidhmi.composetodolist.model.ToDoStatus
import com.dat.androidhmi.composetodolist.model.ToDoTask
import org.junit.Assert
import org.junit.Test

class ToDoTaskWithStepsExtTest {

    @Test
    fun toTask() {
        Assert.assertEquals(
            listOf(
                ToDoTask(
                    id = "id",
                    name = "name",
                    status = ToDoStatus.IN_PROGRESS,
                    dueDate = null,
                    repeat = ToDoRepeat.NEVER,
                    steps = listOf(),
                    createdAt = DateFactory.constantDate,
                    updatedAt = DateFactory.constantDate,
                )
            ),
            listOf(
                ToDoTaskWithSteps(
                    task = ToDoTaskDb(
                        id = "id",
                        name = "name",
                        status = ToDoStatus.IN_PROGRESS,
                        dueDate = null,
                        repeat = ToDoRepeat.NEVER,
                        listId = "listId",
                        createdAt = DateFactory.constantDate,
                        updatedAt = DateFactory.constantDate,
                    ),
                    steps = listOf()
                )
            ).taskWithStepsToTask()
        )
    }
}
