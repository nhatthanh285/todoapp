package com.dat.androidhmi.composetodolist.runtime.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.dat.androidhmi.composetodolist.features.todo.scheduled.ui.ScheduledTodayScreen
import com.dat.androidhmi.composetodolist.features.todo.scheduled.ui.ScheduledViewModel

fun NavGraphBuilder.ScheduledTodayNavHost(
    navController: NavHostController,
    backIcon: ImageVector
) {
    navigation(
        startDestination = ScheduledTodayFlow.ScheduledTodayScreen.route,
        route = ScheduledTodayFlow.Root.route
    ) {
        composable(
            route = ScheduledTodayFlow.ScheduledTodayScreen.route,
            arguments = ScheduledTodayFlow.ScheduledTodayScreen.arguments
        ) {
            val viewModel = hiltViewModel<ScheduledViewModel>()
            ScheduledTodayScreen(
                viewModel = viewModel,
                backIcon = backIcon,
                onClickBack = { navController.navigateUp() },
                onTaskItemClick = { taskId, listId -> navController.navigate(
                    StepFlow.Root.route(
                        taskId,
                        listId
                    )
                ) }
            )
        }
    }
}
