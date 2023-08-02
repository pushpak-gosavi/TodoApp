package com.jetpack.to_docompose.ui.screens.tasks

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.jetpack.to_docompose.R
import com.jetpack.to_docompose.components.PriorityDropdown
import com.jetpack.to_docompose.data.models.Priority
import com.jetpack.to_docompose.ui.theme.LARGE_PADDING
import com.jetpack.to_docompose.ui.theme.MEDIUM_PADDING

@Composable
fun TaskContent(
    title: String,
    onTitleChange:(String) -> Unit,
    description:String,
    onDescriptionChange:(String) -> Unit,
    priority:Priority,
    onPrioritySelected:(Priority) -> Unit
){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colors.background)
        .padding(all = LARGE_PADDING)) {
        OutlinedTextField(modifier = Modifier.fillMaxWidth() ,
            value = title, onValueChange = {onTitleChange(it)},
            label = {Text(text = stringResource(id = R.string.txt_title))},
            textStyle = MaterialTheme.typography.body1,
            singleLine = true)
        Divider(
            modifier = Modifier.padding(MEDIUM_PADDING)
                .background(MaterialTheme.colors.background)
        )
        
        PriorityDropdown(priority = priority, onPrioritySelected = onPrioritySelected)
        OutlinedTextField(value = description, onValueChange = {onDescriptionChange(it)},
            modifier = Modifier.fillMaxSize(),
            label = {Text(text= stringResource(id = R.string.txt_description))},
            textStyle = MaterialTheme.typography.body1)
    }
}

@Composable
@Preview
fun TaskContentPreview(){
    TaskContent(
        title = "",
        onTitleChange = {},
        description = "",
        onDescriptionChange = {},
        priority = Priority.LOW,
        onPrioritySelected = {}
    )
}