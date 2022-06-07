package com.example.to_docompose.ui.screens.tasks

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.example.to_docompose.util.Action

@Composable
fun TaskScreen(
    navigateToTaskScreen : (Action) -> Unit
){
    Scaffold(
        topBar = {
                 TaskAppBar(navigateToListScreen = navigateToTaskScreen)
        },
        content = {}
    )
}