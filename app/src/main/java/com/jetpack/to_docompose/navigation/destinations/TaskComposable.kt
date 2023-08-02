package com.jetpack.to_docompose.navigation.destinations

import android.util.Log
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import com.google.accompanist.navigation.animation.composable
import androidx.navigation.compose.navArgument
import com.jetpack.to_docompose.ui.screens.tasks.TaskScreen
import com.jetpack.to_docompose.ui.viewmodels.SharedViewModel
import com.jetpack.to_docompose.util.Action
import com.jetpack.to_docompose.util.Constants.TASK_ARGUMENT_KEY
import com.jetpack.to_docompose.util.Constants.TASK_SCREEN

@ExperimentalAnimationApi
fun NavGraphBuilder.taskComposable(
    navigateToListScreen: (Action) -> Unit,
    sharedViewModel: SharedViewModel
){
    composable(
        route = TASK_SCREEN,
        arguments = listOf(navArgument(TASK_ARGUMENT_KEY){
            type = NavType.IntType
        })
    ){
        navBackStackEntry ->
        val taskId = navBackStackEntry.arguments!!.getInt(TASK_ARGUMENT_KEY)
        Log.d("taskComposable", taskId.toString())
        LaunchedEffect(key1 = taskId){
            sharedViewModel.getSelectedTask(taskId = taskId)
        }
        val selectedTask by sharedViewModel.selectedTask.collectAsState()

        LaunchedEffect(key1 = selectedTask){
            if(selectedTask !=null ||taskId == -1)
                sharedViewModel.updateTaskFiled(selectedTask = selectedTask)
        }
        TaskScreen(
            selectedTask = selectedTask
            ,navigateToListScreen = navigateToListScreen
            , sharedViewModel = sharedViewModel)
    }
}