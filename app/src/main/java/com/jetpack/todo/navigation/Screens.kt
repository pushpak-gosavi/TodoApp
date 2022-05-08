package com.jetpack.todo.navigation

import androidx.navigation.NavHostController
import com.jetpack.todo.util.Action
import com.jetpack.todo.util.Constance.LIST_SCREEN

class Screens(navController : NavHostController) {
    val list: (Action) -> Unit = { action ->
        navController.navigate("list/${action.name}") {
            popUpTo(LIST_SCREEN){inclusive = true}
        }
    }

    val task : (Int) -> Unit = { taskId ->
        navController.navigate("task/$taskId")
    }
}