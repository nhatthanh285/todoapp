package com.dat.androidhmi.composetodolist.features.logout.data

import com.dat.androidhmi.composetodolist.model.User
import kotlinx.coroutines.flow.Flow

interface ILogoutEnvironment {
    suspend fun logout()
    fun getUser(): Flow<User>
}
