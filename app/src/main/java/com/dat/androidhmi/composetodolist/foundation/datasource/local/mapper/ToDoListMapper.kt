package com.dat.androidhmi.composetodolist.foundation.datasource.local.mapper

import com.dat.androidhmi.composetodolist.foundation.datasource.local.model.ToDoListDb
import com.dat.androidhmi.composetodolist.foundation.datasource.local.model.ToDoListWithTasks
import com.dat.androidhmi.composetodolist.model.GroupIdWithList
import com.dat.androidhmi.composetodolist.model.ToDoList
import com.dat.androidhmi.composetodolist.model.ToDoTask

fun List<ToDoListDb>.toToDoList(): List<ToDoList> {
    return map { it.toToDoList() }
}

fun List<ToDoListWithTasks>.toDoListWithTasksToToDoList(): List<ToDoList> {
    return map { it.toToDoList() }
}

fun ToDoListWithTasks.toToDoList(): ToDoList {
    return list.toToDoList(taskWithSteps.taskWithStepsToTask())
}

fun ToDoListDb.toToDoList(tasks: List<ToDoTask> = listOf()): ToDoList {
    return ToDoList(
        id = id,
        name = name,
        color = color,
        tasks = tasks,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}

fun List<ToDoList>.toToDoListDb(groupId: String): List<ToDoListDb> {
    return map { it.toToDoListDb(groupId) }
}

fun List<GroupIdWithList>.toToDoListDb(): List<ToDoListDb> {
    return map { it.list.toToDoListDb(it.groupId) }
}

private fun ToDoList.toToDoListDb(groupId: String): ToDoListDb {
    return ToDoListDb(
        id = id,
        name = name,
        color = color,
        groupId = groupId,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}
