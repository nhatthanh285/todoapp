package com.dat.androidhmi.composetodolist.features.splash.data

import com.dat.androidhmi.composetodolist.model.Credential
import kotlinx.coroutines.flow.Flow

interface ISplashEnvironment {
    fun getCredential(): Flow<Credential>
}
