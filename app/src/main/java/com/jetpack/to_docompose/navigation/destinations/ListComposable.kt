package com.jetpack.to_docompose.navigation.destinations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import com.google.accompanist.navigation.animation.composable
import androidx.navigation.compose.navArgument
import com.jetpack.to_docompose.ui.screens.list.ListScreen
import com.jetpack.to_docompose.ui.viewmodels.SharedViewModel
import com.jetpack.to_docompose.util.Constants.LIST_ARGUMENT_KEY
import com.jetpack.to_docompose.util.Constants.LIST_SCREEN
import com.jetpack.to_docompose.util.toAction

@ExperimentalAnimationApi
@ExperimentalMaterialApi
fun NavGraphBuilder.listComposable(
    navigateToTaskScreen: (taskId: Int) -> Unit,
    sharedViewModel: SharedViewModel
) {
    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY) {
            type = NavType.StringType
        })
    ) {
        navBackStackEntry ->
            val action = navBackStackEntry.arguments?.getString(LIST_ARGUMENT_KEY).toAction() // action is an extention function

        LaunchedEffect(key1 =action){
            sharedViewModel.action.value = action
        }

        ListScreen(
            navigateToTaskScreen = navigateToTaskScreen,
            sharedViewModel = sharedViewModel
        )
    }
}