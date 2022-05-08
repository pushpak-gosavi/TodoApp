package com.jetpack.todo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.jetpack.todo.navigation.destinations.listComposable
import com.jetpack.todo.navigation.destinations.taskComposable
import com.jetpack.todo.util.Constance.LIST_SCREEN

@Composable
fun SetupNavigation(
    navController: NavHostController
) {
    val screen = remember(navController) {
        Screens(navController = navController)
    }
    NavHost(navController = navController, startDestination = LIST_SCREEN) {
        listComposable(
            navigateToTaskScreen = screen.task
        )
        taskComposable (
            navigateToListScreen = screen.list
                )
    }
}