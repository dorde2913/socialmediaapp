package com.example.socialmediapp.ui.screens.authentication.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BorderedButton(
    modifier: Modifier = Modifier,
    onClick: ()->Unit,
    inverseColor: Boolean,
    enabled: Boolean = true,
    content: @Composable()()->Unit,
){
    Button(
        modifier = modifier
            .padding(horizontal = 32.dp)
            .height(52.dp),
        colors = ButtonColors(
            containerColor = if (inverseColor) MaterialTheme.colorScheme.onPrimaryContainer else  MaterialTheme.colorScheme.primaryContainer,
            contentColor = if (inverseColor) MaterialTheme.colorScheme.primaryContainer else  MaterialTheme.colorScheme.onPrimaryContainer,
            disabledContentColor = MaterialTheme.colorScheme.primary,
            disabledContainerColor = MaterialTheme.colorScheme.primary
        ),
        border = BorderStroke(
            width = 3.dp,
            color = MaterialTheme.colorScheme.outline
        ),
        onClick = {
            onClick()
        },
        enabled = enabled
    ){
        content()
    }
}