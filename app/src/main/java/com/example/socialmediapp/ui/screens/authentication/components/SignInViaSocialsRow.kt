package com.example.socialmediapp.ui.screens.authentication.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SignInViaSocialsRow(
    label: String
){
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(32.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        HorizontalDivider(
            modifier = Modifier.weight(0.3f),
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
        Text(
            text = "Or",
            modifier = Modifier.padding(horizontal = 16.dp),
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
        HorizontalDivider(
            modifier = Modifier.weight(0.3f),
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }

    Text(label,
        color = MaterialTheme.colorScheme.onPrimaryContainer)

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){

        /*
        placeholders
         */
        IconButton(
            onClick = {}
        ) {
            Icon(Icons.Default.Menu,null)
        }

        IconButton(
            onClick = {}
        ) {
            Icon(Icons.Default.Edit,null)
        }

        IconButton(
            onClick = {}
        ) {
            Icon(Icons.Default.Build,null)
        }

    }
}