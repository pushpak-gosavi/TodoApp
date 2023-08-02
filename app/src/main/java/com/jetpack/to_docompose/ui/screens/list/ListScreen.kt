package com.jetpack.to_docompose.ui.screens.list

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.jetpack.to_docompose.R
import com.jetpack.to_docompose.ui.theme.fabBackgroundColor
import com.jetpack.to_docompose.ui.viewmodels.SharedViewModel
import com.jetpack.to_docompose.util.Action
import com.jetpack.to_docompose.util.SearchAppBarState
import kotlinx.coroutines.launch

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun ListScreen(
    navigateToTaskScreen: (taskId: Int) -> Unit,
    sharedViewModel: SharedViewModel
) {
    LaunchedEffect(key1 = true){
        //Log.d("list_screen", "Launched Effect Triggered")
        sharedViewModel.getAllTasks()
        sharedViewModel.readSortState()
    }

    val action by sharedViewModel.action
    val allTasks by sharedViewModel.allTasks.collectAsState()
//        for(task in  allTasks.value){
//            Log.d("list_Screen", task.title)
//        }

    val searchedTasks by sharedViewModel.searchedTasks.collectAsState()
    val sortState by sharedViewModel.sortState.collectAsState()
    val lowPriorityTasks by sharedViewModel.lowPriorityTasks.collectAsState()
    val highPriorityTasks by sharedViewModel.highPriorityTasks.collectAsState()

    val searchAppBarState: SearchAppBarState
            by sharedViewModel.searchAppBarState
    val searchTextState: String by sharedViewModel.searchTextState

    val scaffoldState = rememberScaffoldState()
    DisplaySnackBar(
        scaffoldState = scaffoldState,
        handledDatabaseAction = { sharedViewModel.handleDatabaseActions(action = action) },
        taskTitle = sharedViewModel.title.value,
        action = action,
        onUnDoClicked = {
            sharedViewModel.action.value = it
        }
    )
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            ListAppBar(
                sharedViewModel = sharedViewModel,
                searchAppBarState = searchAppBarState,
                searchTextState = searchTextState
            )
        },
        content = {
                  ListContent(
                      allTasks = allTasks,
                      navigateToTaskScreen = navigateToTaskScreen,
                      searchAppBarState = searchAppBarState,
                      searchedTasks = searchedTasks,
                      lowPriorityTasks = lowPriorityTasks,
                      highPriorityTasks = highPriorityTasks,
                      sortState = sortState,
                      onSwipeToDelete = { action, task ->
                          sharedViewModel.action.value = action
                          sharedViewModel.updateTaskFiled(selectedTask = task)
                      }
                  )
        },
        floatingActionButton = {
            ListFab(onFabClicked = navigateToTaskScreen)
        }
    )
}

@Composable
fun ListFab(
    onFabClicked: (taskId: Int) -> Unit
) {
    FloatingActionButton(
        onClick = {
            onFabClicked(-1)
        },
        backgroundColor = MaterialTheme.colors.fabBackgroundColor
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(
                id = R.string.add_button
            ),
            tint = Color.White
        )
    }
}

@Composable
fun DisplaySnackBar(
    scaffoldState: ScaffoldState,
    handledDatabaseAction : () -> Unit,
    taskTitle : String,
    action: Action,
    onUnDoClicked: (Action) -> Unit
){
    handledDatabaseAction()
    val scope = rememberCoroutineScope()
    LaunchedEffect(key1 = action){
        if(action != Action.NO_ACTION) {
            scope.launch {
                val snackBarResult = scaffoldState.snackbarHostState.showSnackbar(
                    message = setMessage(action = action, taskTitle= taskTitle ),
                    actionLabel = setActionLabel(action = action)
                )
                undoDeletedTask(
                    action=action,
                    snackBarResult = snackBarResult,
                    onUnDoClicked = onUnDoClicked)
            }
        }
    }
}

private  fun setMessage(action: Action, taskTitle:String) : String{
    return  when (action){
        Action.DELETE_ALL -> "All Tasks Removed."
        else -> "${action.name}: $taskTitle"
    }

}
private fun setActionLabel(action: Action) : String{
    return if(action.name == "DELETE"){
        "UNDO"
    }else{
        "OK"
    }
}

private fun undoDeletedTask(
    action: Action,
    snackBarResult: SnackbarResult,
    onUnDoClicked:(Action) -> Unit,
){
    if(snackBarResult == SnackbarResult.ActionPerformed
        && action == Action.DELETE){
        onUnDoClicked(Action.UNDO)
    }
}