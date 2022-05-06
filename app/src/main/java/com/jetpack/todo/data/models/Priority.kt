package com.jetpack.todo.data.models

import androidx.compose.ui.graphics.Color
import com.jetpack.todo.ui.theme.HighPriorityColor
import com.jetpack.todo.ui.theme.LowPriorityColor
import com.jetpack.todo.ui.theme.MediumPriorityColor
import com.jetpack.todo.ui.theme.NonePriorityColor

enum class Priority (val  color : Color){
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor),
}