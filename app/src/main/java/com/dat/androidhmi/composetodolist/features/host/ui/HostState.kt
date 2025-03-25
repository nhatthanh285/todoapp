package com.dat.androidhmi.composetodolist.features.host.ui

import com.dat.androidhmi.composetodolist.model.Theme
import javax.annotation.concurrent.Immutable

@Immutable
data class HostState(val theme: Theme = Theme.SYSTEM)
