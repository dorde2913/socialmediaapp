package com.example.socialmediapp.ui.screens.authentication


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.socialmediapp.R
import com.example.socialmediapp.ui.theme.SocialmediAppTheme

@Composable
fun GreetingScreen(
    onLoginPress: ()->Unit,
    onSignUpPress: ()->Unit
){


    Column(
        modifier = Modifier.fillMaxSize()
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

        // vertikalno: logo -> login form -> dugme za signup?


        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = "logo",
            modifier = Modifier.fillMaxWidth()
                .height(184.dp)
                .padding(top = 72.dp),
            contentScale = ContentScale.Crop
        )


        Text(
            text = "Hello",
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onPrimary
        )

        Text(
            text = "Welcome to AppName",
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onPrimary
        )


        Button(
            modifier = Modifier.fillMaxWidth()
                .padding(32.dp)
                .height(52.dp),
            colors = ButtonColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                disabledContentColor = MaterialTheme.colorScheme.primary,
                disabledContainerColor = MaterialTheme.colorScheme.primary
            ),

            //enabled = false,
            onClick = {
                onLoginPress()
            }
        ){
            Text(
                text = "Login",
                fontSize = 20.sp
            )
        }

        Button(
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 32.dp)
                .height(52.dp),
            colors = ButtonColors(
                containerColor = MaterialTheme.colorScheme.onPrimaryContainer,
                contentColor = MaterialTheme.colorScheme.primaryContainer,
                disabledContentColor = MaterialTheme.colorScheme.primary,
                disabledContainerColor = MaterialTheme.colorScheme.primary
            ),
            border = BorderStroke(
                width = 3.dp,
                color = MaterialTheme.colorScheme.inversePrimary
            ),
            onClick = {
                onSignUpPress()
            }
        ){
            Text(
                text = "Sign up",
                fontSize = 20.sp
            )
        }


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

        Text("Sign up using",
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

}

@Preview
@Composable
fun AuthScreenPreview(){
    SocialmediAppTheme(
        darkTheme = true
    ) {
        GreetingScreen(
            {},
            {}
        )
    }
}

@Preview
@Composable
fun AuthScreenLightModePreview(){
    SocialmediAppTheme() {
        GreetingScreen(
            {},
            {}
        )
    }
}