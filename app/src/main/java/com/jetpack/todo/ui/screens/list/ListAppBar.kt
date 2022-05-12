package com.jetpack.todo.ui.screens.list

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import com.jetpack.todo.componants.PriorityItem
import com.jetpack.todo.ui.theme.TOP_APP_BAR_HEIGHT

@Composable
fun ListAppBar(
){
//    DefaultListAppBar(
//        onSearchClicked ={},
//        onSortClicked = {},
//        onDeleteClicked = {}
//    )
    SearchAppBar(
        text = "",
        onTextChange = {},
        onCloseClicked = {},
        onSearchClicked = {}
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
fun SearchAppBar(
    text : String,
    onTextChange :(String) -> Unit,
    onCloseClicked : () -> Unit,
    onSearchClicked: (String) -> Unit
){
    Surface(modifier = Modifier
        .fillMaxWidth()
        .height(TOP_APP_BAR_HEIGHT),
        elevation = AppBarDefaults.TopAppBarElevation,
        color = MaterialTheme.colors.topAppBarBackgroundColor
    ) {
        TextField(
            value = text,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = {
                onTextChange(it)
            },
            placeholder =  {
                Text(
                    modifier = Modifier.alpha(ContentAlpha.medium),
                    text = "Search",
                color = Color.White)
        },
            textStyle = TextStyle(
                color = MaterialTheme.colors.topAppbarContentColor,
                fontSize = MaterialTheme.typography.subtitle1.fontSize
            ),
            singleLine = true,
            leadingIcon = {
                IconButton(
                    modifier = Modifier.alpha(ContentAlpha.disabled),
                    onClick = { }) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                    contentDescription = "Search Icon",
                    tint = MaterialTheme.colors.topAppbarContentColor)

                }
            },
            trailingIcon = {
                IconButton(onClick = {onCloseClicked()}) {
                    Icon(imageVector = Icons.Filled.Close,
                    contentDescription = "Close icon",
                    tint = MaterialTheme.colors.topAppbarContentColor)
                }
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearchClicked(text)
                }
            ),
            colors = TextFieldDefaults.textFieldColors(
                cursorColor = MaterialTheme.colors.topAppbarContentColor,
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                backgroundColor = Color.Transparent
            )
        )
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

@Composable
@Preview
private fun SearchAppbarPreview() {
    SearchAppBar(
        text = "",
        onTextChange = {},
        onCloseClicked = {},
        onSearchClicked = {}
    )
}
