package com.example.socialmediapp.ui.screens.authentication

import androidx.compose.foundation.Image

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.socialmediapp.R
import com.example.socialmediapp.ui.screens.authentication.components.AuthColumn
import com.example.socialmediapp.ui.screens.authentication.components.BorderedButton
import com.example.socialmediapp.ui.theme.SocialmediAppTheme

@Composable
fun LoginScreen(){

    //val viewModel: AuthViewModel = hiltViewModel()+

    //temp vals
    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    AuthColumn {
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = "logo",
            modifier = Modifier.fillMaxWidth()
                .padding(top = 72.dp)
                .padding(horizontal = 32.dp),
            //contentScale = ContentScale.Crop
        )

        Text(
            text = "Welcome Back",
            modifier = Modifier.padding(top = 32.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.onPrimary
        )

        Text(
            text = "Please enter your credentials",
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.onPrimary
        )


        //login form

        //kao svaki textfield da bude blurred?



        LoginForm(
            modifier = Modifier.padding(top = 32.dp),
            username = username,
            password = password,
            setUsername = {username = it},
            setPassword = {password = it}
        )



    }
}

@Composable
fun LoginForm(
    modifier: Modifier = Modifier,
    username: String,
    password: String,
    setUsername: (String) ->Unit,
    setPassword: (String) -> Unit
){
    val textFieldColors =OutlinedTextFieldDefaults.colors()
        .copy(
            unfocusedIndicatorColor = MaterialTheme.colorScheme.outline,
            focusedIndicatorColor = MaterialTheme.colorScheme.outline,
            focusedTextColor = MaterialTheme.colorScheme.outline,
            unfocusedLabelColor = MaterialTheme.colorScheme.outline,
            focusedLabelColor = MaterialTheme.colorScheme.outline
        )


    Column(
        modifier = modifier.padding(horizontal = 32.dp)
    ){
        OutlinedTextField(
            value = username,
            onValueChange = {setUsername(it)},
            modifier = Modifier
                .widthIn(max = 512.dp)
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            label = {
                Text(text = "Username")
            },
            colors =textFieldColors
        )

        OutlinedTextField(
            value = password,
            onValueChange = {setPassword(it)},
            modifier = Modifier
                .widthIn(max = 512.dp)
                .fillMaxWidth(),
            label = {
                Text(text = "Password")
            },
            visualTransformation = PasswordVisualTransformation(),
            colors = textFieldColors
        )

        BorderedButton(
            modifier = Modifier
                .align(Alignment.End)
                .padding(top = 16.dp),
            onClick = {

            },
            inverseColor = false,
        ) {
            Text(
                text = "Log in",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}



@Preview
@Composable
fun LoginScreenPreviewLightMode(){
    SocialmediAppTheme {
        LoginScreen()
    }
}
@Preview
@Composable
fun LoginScreenPreviewDarkMode(){
    SocialmediAppTheme(
        darkTheme = true
    ) {
        LoginScreen()
    }
}
@Preview(
    device = "spec:width=1280dp,height=800dp,dpi=240"
)
@Composable
fun LoginScreenTabletPreview(){
    SocialmediAppTheme() {
        LoginScreen()
    }
}