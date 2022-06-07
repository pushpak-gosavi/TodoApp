package com.example.to_docompose.ui.screens.tasks

import android.app.Notification
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.to_docompose.ui.theme.topAppBarBackgroundColor
import com.example.to_docompose.ui.theme.topAppBarContentColor
import com.example.to_docompose.util.Action
import com.example.to_docompose.R
import com.example.to_docompose.data.models.Priority
import com.example.to_docompose.data.models.ToDoTask

@Composable
fun TaskAppBar(
    navigateToListScreen: (Action) -> Unit
){
    NewTaskAppBar(navigateToListScreen = navigateToListScreen)
}

@Composable
fun NewTaskAppBar(
    navigateToListScreen: (Action) -> Unit
){
    TopAppBar(
        navigationIcon = {
                         BackAction(onBackClicked = navigateToListScreen)
        },
        title = {
            Text(text = stringResource(id = R.string.add_task),
                color = MaterialTheme.colors.topAppBarContentColor)
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
        actions = {
            AddAction(onBackClicked = navigateToListScreen)
        }
    )
}

@Composable
fun BackAction(
    onBackClicked: (Action) -> Unit
){
    IconButton(onClick = {onBackClicked(Action.NO_ACTION)}) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = stringResource(id = R.string.back_arrow),
            tint = MaterialTheme.colors.topAppBarContentColor)
        
    }
}

@Composable
fun AddAction(
    onBackClicked: (Action) -> Unit
){
    IconButton(onClick = {onBackClicked(Action.ADD)}) {
        Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = stringResource(id = R.string.add_task),
            tint = MaterialTheme.colors.topAppBarContentColor)

    }
}

@Composable
fun ExistingTaskAppBar(
    selectedTask: ToDoTask,
    navigateToListScreen: (Action) -> Unit
){
    TopAppBar(
        navigationIcon = {
                         CloseAction(onClosedClicked = navigateToListScreen)
        },
        title = {
            Text(text = selectedTask.title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colors.topAppBarContentColor)
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
        actions = {
            DeleteAction(onDeleteClicked = navigateToListScreen)
            UpdateAction(onUpdateClicked = navigateToListScreen)
        }
    )
}

@Composable
fun CloseAction(
    onClosedClicked: (Action) -> Unit
){
    IconButton(onClick = {onClosedClicked(Action.NO_ACTION)}) {
        Icon(imageVector = Icons.Filled.Close,
        contentDescription = stringResource(id = R.string.close_icon),
        tint = MaterialTheme.colors.topAppBarContentColor)        
    }
}

@Composable
fun UpdateAction(
    onUpdateClicked: (Action) -> Unit
){
    IconButton(onClick = { onUpdateClicked(Action.UPDATE)}) {
        Icon(imageVector = Icons.Filled.Check,
            contentDescription = stringResource(id = R.string.update_icon),
            tint = MaterialTheme.colors.topAppBarContentColor)
    }
}
@Composable
fun DeleteAction(
    onDeleteClicked: (Action) -> Unit
){
    IconButton(onClick = { onDeleteClicked(Action.DELETE)}) {
        Icon(imageVector = Icons.Filled.Delete,
        tint = MaterialTheme.colors.topAppBarContentColor,
        contentDescription = stringResource(id = R.string.delete_icon))
    }
}

@Composable
@Preview
fun NewTaskAppBarPreview(){
    TaskAppBar(
        navigateToListScreen = {}
    )
}
@Composable
@Preview
fun ExistingAppBarPreview(){
    ExistingTaskAppBar(selectedTask = ToDoTask(id = 1, title = "Pushpak", description = "Random Text", priority = Priority.MEDIUM), navigateToListScreen = {})
}