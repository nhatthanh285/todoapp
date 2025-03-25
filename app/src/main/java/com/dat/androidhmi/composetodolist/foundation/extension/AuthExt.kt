package com.dat.androidhmi.composetodolist.foundation.extension

import com.dat.androidhmi.composetodolist.model.Credential

fun Credential.isLoggedIn() = token.isNotBlank()
