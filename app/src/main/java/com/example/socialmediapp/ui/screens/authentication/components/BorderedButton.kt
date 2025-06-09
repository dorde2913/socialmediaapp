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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import androidx.core.graphics.ColorUtils

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
            .height(52.dp),
        colors = ButtonColors(
            containerColor = if (inverseColor) MaterialTheme.colorScheme.onPrimaryContainer else  MaterialTheme.colorScheme.primaryContainer,
            contentColor = if (inverseColor) MaterialTheme.colorScheme.primaryContainer else  MaterialTheme.colorScheme.onPrimaryContainer,
            disabledContentColor = if (inverseColor) MaterialTheme.colorScheme.primaryContainer.darken(0.4f)
                                    else  MaterialTheme.colorScheme.onPrimaryContainer.darken(0.4f),
            disabledContainerColor = if (inverseColor) MaterialTheme.colorScheme.onPrimaryContainer.darken(0.4f)
                                    else  MaterialTheme.colorScheme.primaryContainer.darken(0.4f),
        ),
        border = BorderStroke(
            width = 3.dp,
            color = if (enabled) MaterialTheme.colorScheme.outline else MaterialTheme.colorScheme.outline.darken(0.4f)
        ),
        onClick = {
            onClick()
        },
        enabled = enabled
    ){
        content()
    }
}

fun Color.lighten(factor: Float): Color {
    val newColor = ColorUtils.blendARGB(this.toArgb(), Color.White.toArgb(), factor)
    return Color(newColor)
}
fun Color.darken(factor: Float): Color {
    val newColor = ColorUtils.blendARGB(this.toArgb(), Color.Black.toArgb(), factor)
    return Color(newColor)
}