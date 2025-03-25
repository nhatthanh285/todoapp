package com.dat.androidhmi.composetodolist.features.logout.data

import com.dat.androidhmi.composetodolist.foundation.datasource.preference.provider.CredentialProvider
import com.dat.androidhmi.composetodolist.foundation.datasource.preference.provider.UserProvider
import com.dat.androidhmi.composetodolist.model.Credential
import com.dat.androidhmi.composetodolist.model.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LogoutEnvironment @Inject constructor(
    private val credentialProvider: CredentialProvider,
    private val userProvider: UserProvider
) : ILogoutEnvironment {
    override suspend fun logout() {
        credentialProvider.setCredential(Credential(token = ""))
        userProvider.setUser(User(email = ""))
    }

    override fun getUser(): Flow<User> {
        return userProvider.getUser()
    }

}
