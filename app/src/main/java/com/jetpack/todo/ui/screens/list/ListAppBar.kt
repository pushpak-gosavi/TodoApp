package com.jetpack.todo.ui.screens.list

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.jetpack.todo.R
import com.jetpack.todo.ui.theme.topAppBarBackgroundColor
import com.jetpack.todo.ui.theme.topAppbarContentColor

@Composable
fun ListAppBar(){
    DefaultListAppBar()
}

@Composable
fun DefaultListAppBar() {
    TopAppBar(
        title = {
            Text( text = stringResource(id = R.string.default_list_appbar),
           color = MaterialTheme.colors.topAppbarContentColor )},
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor
    )
}
@Composable
@Preview
private fun DefaultListAppBarPreview(){
    DefaultListAppBar()
}
