package com.dat.androidhmi.composetodolist.foundation.extension

import com.dat.androidhmi.composetodolist.DateFactory
import com.dat.androidhmi.composetodolist.foundation.datasource.local.mapper.toStep
import com.dat.androidhmi.composetodolist.foundation.datasource.local.model.ToDoStepDb
import com.dat.androidhmi.composetodolist.model.ToDoStatus
import com.dat.androidhmi.composetodolist.model.ToDoStep
import org.junit.Assert
import org.junit.Test

class ToDoStepDbExtTest {

    @Test
    fun toStepDb() {
        Assert.assertEquals(
            listOf(
                ToDoStep(
                    id = "id",
                    name = "name",
                    status = ToDoStatus.IN_PROGRESS,
                    createdAt = DateFactory.constantDate,
                    updatedAt = DateFactory.constantDate,
                )
            ),
            listOf(
                ToDoStepDb(
                    id = "id",
                    name = "name",
                    status = ToDoStatus.IN_PROGRESS,
                    taskId = "taskId",
                    createdAt = DateFactory.constantDate,
                    updatedAt = DateFactory.constantDate,
                )
            ).toStep()
        )
    }
}
