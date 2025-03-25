package com.dat.androidhmi.composetodolist.foundation.extension

import com.dat.androidhmi.composetodolist.DateFactory
import com.dat.androidhmi.composetodolist.foundation.datasource.local.mapper.toToDoListDb
import com.dat.androidhmi.composetodolist.foundation.datasource.local.model.ToDoListDb
import com.dat.androidhmi.composetodolist.model.ToDoColor
import com.dat.androidhmi.composetodolist.model.ToDoList
import org.junit.Assert
import org.junit.Test

class ToDoListExtTest {

    @Test
    fun toListDb() {
        Assert.assertEquals(
            listOf(
                ToDoListDb(
                    id = "id",
                    name = "name",
                    color = ToDoColor.PURPLE,
                    groupId = "groupId",
                    createdAt = DateFactory.constantDate,
                    updatedAt = DateFactory.constantDate,
                )
            ),
            listOf(
                ToDoList(
                    id = "id",
                    name = "name",
                    color = ToDoColor.PURPLE,
                    tasks = listOf(),
                    createdAt = DateFactory.constantDate,
                    updatedAt = DateFactory.constantDate,
                )
            ).toToDoListDb("groupId")
        )
    }

}
