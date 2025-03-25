package com.dat.androidhmi.composetodolist.features.logout.ui

import androidx.compose.runtime.Immutable
import com.dat.androidhmi.composetodolist.model.User

@Immutable
data class LogoutState(val user: User = User())
