package com.jetpack.todo.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.jetpack.todo.ui.screens.list.ListScreen
import com.jetpack.todo.ui.theme.viewmodels.SharedViewModel
import com.jetpack.todo.util.Constance.LIST_SCREEN
import com.jetpack.todo.util.Constance.List_ARGUMENT_KEY

fun NavGraphBuilder.listComposable(
    navigateToTaskScreen: (taskId: Int) -> Unit,
    sharedViewModel: SharedViewModel
) {
    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(List_ARGUMENT_KEY) {
            type = NavType.StringType
        })
    ) {
        ListScreen(
            navigateToTaskScreen = navigateToTaskScreen,
            sharedViewModel = sharedViewModel
        )
    }
}