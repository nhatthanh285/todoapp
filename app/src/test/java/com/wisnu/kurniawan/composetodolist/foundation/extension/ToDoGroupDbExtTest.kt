package com.dat.androidhmi.composetodolist.foundation.extension

import com.dat.androidhmi.composetodolist.DateFactory
import com.dat.androidhmi.composetodolist.foundation.datasource.local.mapper.toGroup
import com.dat.androidhmi.composetodolist.foundation.datasource.local.model.ToDoGroupDb
import com.dat.androidhmi.composetodolist.model.ToDoGroup
import org.junit.Assert
import org.junit.Test

class ToDoGroupDbExtTest {

    @Test
    fun groupDbToGroup() {
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
                ToDoGroupDb(
                    id = "id",
                    name = "name",
                    createdAt = DateFactory.constantDate,
                    updatedAt = DateFactory.constantDate,
                )
            ).toGroup()
        )
    }

}
