package com.example.to_docompose.ui.screens.tasks

import android.app.Notification
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.to_docompose.ui.theme.topAppBarBackgroundColor
import com.example.to_docompose.ui.theme.topAppBarContentColor
import com.example.to_docompose.util.Action
import com.example.to_docompose.R

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
@Preview
fun NewTaskAppBarPreview(){
    TaskAppBar(
        navigateToListScreen = {}
    )
}