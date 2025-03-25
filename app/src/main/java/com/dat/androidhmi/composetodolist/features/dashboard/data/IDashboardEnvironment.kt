package com.dat.androidhmi.composetodolist.features.dashboard.data

import com.dat.androidhmi.composetodolist.model.ToDoTaskDiff
import com.dat.androidhmi.composetodolist.model.User
import kotlinx.coroutines.flow.Flow

interface IDashboardEnvironment {
    fun getUser(): Flow<User>
    fun listenToDoTaskDiff(): Flow<ToDoTaskDiff>
}
