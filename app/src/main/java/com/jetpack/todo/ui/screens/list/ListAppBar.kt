package com.jetpack.todo.ui.screens.list

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.jetpack.todo.R
import com.jetpack.todo.ui.theme.topAppBarBackgroundColor
import com.jetpack.todo.ui.theme.topAppbarContentColor

@Composable
fun ListAppBar(
){
    DefaultListAppBar(
        onSearchClicked ={}
    )
}

@Composable
fun DefaultListAppBar(
    onSearchClicked: () -> Unit
) {
    TopAppBar(
        title = {
            Text( text = stringResource(id = R.string.default_list_appbar),
           color = MaterialTheme.colors.topAppbarContentColor )},
        actions = {
            ListAppBarAction (onSearchClicked = onSearchClicked)
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
    )
}
@Composable
fun ListAppBarAction(
    onSearchClicked: () -> Unit
){
    SearchAction(onSearchClicked = onSearchClicked )
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
@Preview
private fun DefaultListAppBarPreview(){
    DefaultListAppBar(
        onSearchClicked = {}
    )
}
