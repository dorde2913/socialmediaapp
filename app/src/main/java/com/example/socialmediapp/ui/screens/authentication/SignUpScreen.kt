package com.example.socialmediapp.ui.screens.authentication

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.socialmediapp.R
import com.example.socialmediapp.ui.screens.authentication.components.AuthColumn
import com.example.socialmediapp.ui.screens.authentication.components.AuthForm
import com.example.socialmediapp.ui.screens.authentication.components.SignInViaSocialsRow
import com.example.socialmediapp.ui.theme.SocialmediAppTheme


@Composable
fun SignupScreen(){

    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var confirmPassword by rememberSaveable { mutableStateOf("") }


    AuthColumn {
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
            text = stringResource(R.string.welcome_message),
            modifier = Modifier.padding(top = 32.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.onPrimary
        )

        Text(
            text = stringResource(R.string.enter_credentials),
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.onPrimary
        )

        AuthForm(
            modifier = Modifier.padding(top = 32.dp),
            username = username,
            password = password,
            setUsername = {username = it},
            setPassword = {password = it},
            confirmPassword = confirmPassword,
            setConfirmPassword = {confirmPassword = it}
        )



        SignInViaSocialsRow(
            label = stringResource(R.string.sign_in_via)
        )

    }


}

@Preview
@Composable
fun SignupScreenPreviewLightMode(){
    SocialmediAppTheme {
        SignupScreen()
    }
}
@Preview
@Composable
fun SignupScreenPreviewDarkMode(){
    SocialmediAppTheme(
        darkTheme = true
    ) {
        SignupScreen()
    }
}
@Preview(
    device = "spec:width=1280dp,height=800dp,dpi=240"
)
@Composable
fun SignupScreenTabletPreview(){
    SocialmediAppTheme {
        SignupScreen()
    }
}