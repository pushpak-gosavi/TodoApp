package com.example.to_docompose.ui.screens.tasks

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.example.to_docompose.data.models.ToDoTask
import com.example.to_docompose.util.Action

@Composable
fun TaskScreen(
    selectedTask: ToDoTask?,
    navigateToTaskScreen: (Action) -> Unit
) {
    Scaffold(
        topBar = {
            TaskAppBar(selectedTask = selectedTask, navigateToListScreen = navigateToTaskScreen)
        },
        content = {}
    )
}