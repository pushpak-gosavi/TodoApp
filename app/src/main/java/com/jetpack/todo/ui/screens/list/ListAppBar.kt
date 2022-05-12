package com.jetpack.todo.ui.screens.list

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.jetpack.todo.R
import com.jetpack.todo.data.models.Priority
import com.jetpack.todo.ui.theme.topAppBarBackgroundColor
import com.jetpack.todo.ui.theme.topAppbarContentColor
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.jetpack.todo.componants.PriorityItem

@Composable
fun ListAppBar(
){
    DefaultListAppBar(
        onSearchClicked ={},
        onSortClicked = {},
        onDeleteClicked = {}
    )
}

@Composable
fun DefaultListAppBar(
    onSearchClicked: () -> Unit,
    onSortClicked: (Priority) -> Unit,
    onDeleteClicked: () -> Unit
) {
    TopAppBar(
        title = {
            Text( text = stringResource(id = R.string.default_list_appbar),
           color = MaterialTheme.colors.topAppbarContentColor )},
        actions = {
            ListAppBarAction (onSearchClicked = onSearchClicked,
            onSortClicked = onSortClicked,
            onDeleteClicked = onDeleteClicked)
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
    )
}
@Composable
fun ListAppBarAction(
    onSearchClicked: () -> Unit,
    onSortClicked: (Priority) -> Unit,
    onDeleteClicked: () -> Unit
){
    SearchAction(onSearchClicked = onSearchClicked )
    SortAction(onSortClicked =onSortClicked )
    DeleteAction (onDeleteClicked = onDeleteClicked)
}
@Composable
fun SearchAction(
    onSearchClicked: () -> Unit
){
    IconButton(onClick =  { onSearchClicked()} ) {
        Icon(imageVector = Icons.Filled.Search,
            contentDescription = stringResource(id = R.string.search_task),
        tint = MaterialTheme.colors.topAppbarContentColor)
    }
}
@Composable
fun SortAction(
    onSortClicked: (Priority) -> Unit
){
    var expanded by remember { mutableStateOf(false)}
    IconButton(onClick = {
        expanded = true
    }) {
        Icon(painter = painterResource(id = R.drawable.ic_filter_list),
        contentDescription = stringResource(id = R.string.sort_tasks),
        tint = MaterialTheme.colors.topAppbarContentColor)
        DropdownMenu(expanded = expanded,
            onDismissRequest = { expanded = false }) {
            
            DropdownMenuItem(onClick = { expanded = false
            onSortClicked(Priority.LOW)}) {
                PriorityItem(priority = Priority.LOW)
                
            }
            DropdownMenuItem(onClick = {
                expanded = false
            onSortClicked(Priority.MEDIUM)}) {
                PriorityItem(priority = Priority.MEDIUM)

            }
            DropdownMenuItem(onClick = {
                expanded = false
            onSortClicked(Priority.HIGH)}) {
                PriorityItem(priority = Priority.HIGH)

            }
            DropdownMenuItem(onClick = {
                expanded = false
            onSortClicked(Priority.NONE)}) {
                PriorityItem(priority = Priority.NONE)

            }
            
        }

    }

}

@Composable
fun DeleteAction(
    onDeleteClicked : () -> Unit
){
    var expanded by remember {
        mutableStateOf(false)
    }
    IconButton(
        onClick = { expanded =true }) {
        
        Icon(painter = painterResource(id = R.drawable.ic_more_vert),
            tint = MaterialTheme.colors.topAppbarContentColor,
            contentDescription = stringResource(id = R.string.delete_all_tasks) )
        DropdownMenu(expanded = expanded, onDismissRequest = {expanded=false }) {
            DropdownMenuItem(onClick = {
                expanded = false
                onDeleteClicked()}) {
                Text(text = stringResource(id = R.string.delete_all))
            }
            
        }
        
    }
}

@Composable
@Preview
private fun DefaultListAppBarPreview(){
    DefaultListAppBar(
        onSearchClicked = {},
        onSortClicked = {},
        onDeleteClicked = {}
    )
}
