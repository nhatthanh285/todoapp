package com.dat.androidhmi.composetodolist.foundation.datasource.server

import com.dat.androidhmi.composetodolist.model.Credential
import com.dat.androidhmi.composetodolist.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.*
import javax.inject.Inject

class ServerProvider @Inject constructor() {

    fun fetchCredential(): Flow<Credential> {
        return flow { emit(Credential(token = UUID.randomUUID().toString())) }
    }

    fun fetchUser(email: String, password: String): Flow<User> {
        return flow { emit(User(email)) }
    }

}
