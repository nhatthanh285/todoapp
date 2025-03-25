package com.dat.androidhmi.composetodolist.features.todo.taskreminder.ui

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.wisnu.foundation.coreloggr.Loggr
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class TaskBroadcastReceiver : BroadcastReceiver() {

    @Inject
    lateinit var taskReminderViewModel: TaskReminderViewModel

    override fun onReceive(context: Context?, intent: Intent?) {
        Loggr.debug("AlarmFlow") { "onReceive ${intent?.action}" }

        when (intent?.action) {
            ACTION_ALARM_SHOW -> {
                taskReminderViewModel.dispatch(TaskReminderAction.AlarmShow(getTaskId(intent)))
            }
            ACTION_NOTIFICATION_COMPLETED -> {
                taskReminderViewModel.dispatch(
                    TaskReminderAction.NotificationCompleted(
                        getTaskId(
                            intent
                        )
                    )
                )
            }
            ACTION_NOTIFICATION_SNOOZE -> {
                taskReminderViewModel.dispatch(
                    TaskReminderAction.NotificationSnooze(
                        getTaskId(
                            intent
                        )
                    )
                )
            }
            Intent.ACTION_BOOT_COMPLETED -> {
                taskReminderViewModel.dispatch(TaskReminderAction.AppBootCompleted)
            }
        }
    }

    private fun getTaskId(intent: Intent?) = intent?.getStringExtra(EXTRA_TASK_ID) ?: ""

    companion object {
        const val EXTRA_TASK_ID = "com.dat.androidhmi.intent.extra.TASK_ID"

        const val ACTION_ALARM_SHOW = "com.dat.androidhmi.intent.action.ALARM_SHOW"
        const val ACTION_NOTIFICATION_COMPLETED = "com.dat.androidhmi.intent.action.NOTIFICATION_COMPLETED"
        const val ACTION_NOTIFICATION_SNOOZE = "com.dat.androidhmi.intent.action.NOTIFICATION_SNOOZE"
    }
}
