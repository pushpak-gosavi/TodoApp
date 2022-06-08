package com.example.to_docompose.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.example.to_docompose.data.models.Priority
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.to_docompose.ui.theme.PRIORITY_DROPDOWN_HEIGHT
import com.example.to_docompose.ui.theme.PRIORITY_INDICATOR_SIZE
import com.example.to_docompose.R

@Composable
fun PriorityDropdown(
    priority: Priority,
    onPrioritySelected: (Priority) -> Unit
) {
    var expanded by remember {
        mutableStateOf(false)
    }
    val angle : Float by animateFloatAsState(targetValue = if(expanded) 180f else 0f)
    Row(modifier = Modifier
        .fillMaxWidth()
        .background(MaterialTheme.colors.background)
        .height(PRIORITY_DROPDOWN_HEIGHT)
        .clickable { expanded = true }
        .border(
            width = 1.dp,
            color = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.disabled),
        shape = MaterialTheme.shapes.small
        ),

        verticalAlignment = Alignment.CenterVertically) {

        Canvas(
            modifier = Modifier
                .size(PRIORITY_INDICATOR_SIZE)
                .weight(1f)
        ) {
            drawCircle(color = priority.color)
        }
        Text(
            text = priority.name,
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier.weight(8f)
        )
        IconButton(
            onClick = { expanded = true },
            modifier = Modifier
                .alpha(ContentAlpha.medium)
                .rotate(angle)
                .weight(1.5f)
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowDropDown,
                contentDescription = stringResource(id = R.string.drop_down_arrow)
            )
        }
    }
    DropdownMenu(
        modifier = Modifier.fillMaxWidth(fraction = 0.94f),
        expanded = expanded,
        onDismissRequest = { expanded = false }) {
        DropdownMenuItem(onClick = {
            expanded = false
            onPrioritySelected(Priority.LOW)
        }) {
            PriorityItem(priority = Priority.LOW)
        }
        DropdownMenuItem(onClick = {
            expanded = false
            onPrioritySelected(Priority.MEDIUM)
        }) {
            PriorityItem(priority = Priority.MEDIUM)

        }
        DropdownMenuItem(onClick = {
            expanded = false
            onPrioritySelected(Priority.HIGH)
        }) {
            PriorityItem(priority = Priority.HIGH)
        }

    }
}

@Composable
@Preview
fun PriorityDropDownPreview() {
    PriorityDropdown(priority = Priority.LOW, onPrioritySelected = {})
}
