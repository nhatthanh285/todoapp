package com.dat.androidhmi.composetodolist.runtime.initializer

import android.content.Context
import androidx.startup.Initializer
import com.wisnu.foundation.liblifecycleloggr.ActivityLifecycleLoggr
import com.dat.androidhmi.composetodolist.runtime.ComposeToDoListApp

class ActivityLifecycleLoggrInitializer : Initializer<ActivityLifecycleLoggr> {
    override fun create(context: Context): ActivityLifecycleLoggr {
        return ActivityLifecycleLoggr().also {
            (context.applicationContext as ComposeToDoListApp)
                .registerActivityLifecycleCallbacks(it)
        }
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = listOf(LoggrInitializer::class.java)
}
