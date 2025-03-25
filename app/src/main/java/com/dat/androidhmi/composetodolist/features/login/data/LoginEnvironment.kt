package com.dat.androidhmi.composetodolist.features.login.data

import com.dat.androidhmi.composetodolist.foundation.datasource.preference.provider.CredentialProvider
import com.dat.androidhmi.composetodolist.foundation.datasource.preference.provider.UserProvider
import com.dat.androidhmi.composetodolist.foundation.datasource.server.ServerProvider
import com.dat.androidhmi.composetodolist.model.Credential
import com.dat.androidhmi.composetodolist.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class LoginEnvironment @Inject constructor(
    private val serverProvider: ServerProvider,
    private val credentialProvider: CredentialProvider,
    private val userProvider: UserProvider
) : ILoginEnvironment {

    override fun login(email: String, password: String): Flow<Any> {
        return merge(
            serverProvider.fetchCredential(),
            serverProvider.fetchUser(email, password)
        ).onEach {
            when (it) {
                is Credential -> credentialProvider.setCredential(it)
                is User -> userProvider.setUser(it)
            }
        }
    }

}
