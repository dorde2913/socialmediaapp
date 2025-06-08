package com.example.socialmediapp.ui.screens.authentication.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush

@Composable
fun AuthColumn(
    modifier: Modifier = Modifier,
    content: @Composable()()->Unit
){
    Column(
        modifier = modifier.fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.primary,
                        MaterialTheme.colorScheme.inversePrimary
                    ),
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        content()
    }

}