package com.jetpack.todo.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.jetpack.todo.util.Action
import com.jetpack.todo.util.Constance.TASK_ARGUMENT_KEY
import com.jetpack.todo.util.Constance.TASK_SCREEN

fun NavGraphBuilder.taskComposable(
    navigateToListScreen : (Action) -> Unit
){
    composable(
        route = TASK_SCREEN,
        arguments = listOf(navArgument(TASK_ARGUMENT_KEY){
            type = NavType.IntType
        })
    ){

    }
}