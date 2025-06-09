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
import androidx.compose.foundation.layout.widthIn
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.socialmediapp.R
import com.example.socialmediapp.ui.screens.authentication.components.AuthColumn
import com.example.socialmediapp.ui.screens.authentication.components.BorderedButton
import com.example.socialmediapp.ui.screens.authentication.components.SignInViaSocialsRow

import com.example.socialmediapp.ui.theme.SocialmediAppTheme

@Composable
fun GreetingScreen(
    onLoginPress: ()->Unit,
    onSignUpPress: ()->Unit
){


    AuthColumn{

        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = "logo",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 72.dp)
                .padding(horizontal = 32.dp),
            //contentScale = ContentScale.Crop
        )


        Text(
            text = stringResource(R.string.greeting),
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.padding(top = 32.dp)
        )

        Text(
            text = stringResource(R.string.welcome_message),
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onPrimary
        )


        BorderedButton(
            modifier = Modifier
                .padding(horizontal = 32.dp)
                .padding(vertical = 32.dp)
                .widthIn(max = 512.dp)
                .fillMaxWidth(),
            onClick = onLoginPress,
            inverseColor = false
        ){
            Text(
                text = stringResource(R.string.login),
                fontSize = 20.sp
            )
        }

        BorderedButton(
            modifier = Modifier
                .padding(horizontal = 32.dp)
                .widthIn(max = 512.dp)
                .fillMaxWidth(),
            onClick = onSignUpPress,
            inverseColor = true
        ){
            Text(
                text = stringResource(R.string.sign_up),
                fontSize = 20.sp
            )
        }


        SignInViaSocialsRow(
            label = stringResource(R.string.sign_up_using)
        )



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

@Preview(
    device = "spec:width=1280dp,height=800dp,dpi=240"
)
@Composable
fun AuthScreenTabletPreview(){
    SocialmediAppTheme() {
        GreetingScreen(
            {},
            {}
        )
    }
}