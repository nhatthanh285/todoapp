package com.dat.androidhmi.composetodolist.foundation.extension

import com.dat.androidhmi.composetodolist.DateFactory
import com.dat.androidhmi.composetodolist.foundation.datasource.local.mapper.groupWithListToGroup
import com.dat.androidhmi.composetodolist.foundation.datasource.local.model.ToDoGroupDb
import com.dat.androidhmi.composetodolist.foundation.datasource.local.model.ToDoGroupWithList
import com.dat.androidhmi.composetodolist.model.ToDoGroup
import org.junit.Assert
import org.junit.Test

class ToDoGroupWithListTest {

    @Test
    fun toDoGroupWithListToGroup() {
        Assert.assertEquals(
            listOf(
                ToDoGroup(
                    id = "id",
                    name = "name",
                    lists = listOf(),
                    createdAt = DateFactory.constantDate,
                    updatedAt = DateFactory.constantDate,
                )
            ),
            listOf(
                ToDoGroupWithList(
                    group = ToDoGroupDb(
                        id = "id",
                        name = "name",
                        createdAt = DateFactory.constantDate,
                        updatedAt = DateFactory.constantDate,
                    ),
                    listWithTasks = listOf()
                )
            ).groupWithListToGroup()
        )
    }

}
