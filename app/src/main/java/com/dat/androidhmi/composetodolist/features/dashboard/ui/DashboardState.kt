package com.dat.androidhmi.composetodolist.features.dashboard.ui

import androidx.compose.runtime.Immutable
import com.dat.androidhmi.composetodolist.model.User

@Immutable
data class DashboardState(val user: User = User())
