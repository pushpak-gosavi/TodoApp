package com.example.to_docompose.ui.screens.tasks

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.example.to_docompose.data.models.Priority
import com.example.to_docompose.data.models.ToDoTask
import com.example.to_docompose.ui.viewmodels.SharedViewModel
import com.example.to_docompose.util.Action

@Composable
fun TaskScreen(
    selectedTask: ToDoTask?,
    sharedViewModel: SharedViewModel,
    navigateToTaskScreen: (Action) -> Unit
) {
    val title:String by sharedViewModel.title
    val description:String by sharedViewModel.description
    val priority:Priority by sharedViewModel.priority

    Scaffold(
        topBar = {
            TaskAppBar(selectedTask = selectedTask, navigateToListScreen = navigateToTaskScreen)
        },
        content = {
            TaskContent(
                title = title,
                onTitleChange = {
                    sharedViewModel.title.value=it
                },
                description = description,
                onDescriptionChange = {
                    sharedViewModel.description.value = it
                },
                priority = priority,
                onPrioritySelected = {
                    sharedViewModel.priority.value = it
                }
            )
        }
    )
}