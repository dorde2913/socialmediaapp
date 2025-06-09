package com.example.socialmediapp.ui.screens.authentication.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.socialmediapp.R

@Composable
fun AuthForm(
    modifier: Modifier = Modifier,
    username: String,
    password: String,
    confirmPassword: String? = null,
    setUsername: (String) ->Unit,
    setPassword: (String) -> Unit,
    setConfirmPassword: (String) ->Unit = {},
){

    val textFieldColors = OutlinedTextFieldDefaults.colors()
        .copy(
            unfocusedIndicatorColor = MaterialTheme.colorScheme.outline,
            focusedIndicatorColor = MaterialTheme.colorScheme.outline,
            focusedTextColor = MaterialTheme.colorScheme.onPrimary,
            unfocusedLabelColor = MaterialTheme.colorScheme.outline,
            focusedLabelColor = MaterialTheme.colorScheme.outline,
            cursorColor = MaterialTheme.colorScheme.onPrimary
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
                .testTag("username"),
            label = {
                Text(text = "Username")
            },
            colors =textFieldColors,
            isError = isUsernameValid(username) != AuthInputError.OKAY && username.isNotEmpty(),
            supportingText = {
                if (isUsernameValid(username) != AuthInputError.OKAY && username.isNotEmpty())
                    ErrorMessage(
                        isUsernameValid(username),
                        isPassword = false
                    )
            }
        )

        OutlinedTextField(
            value = password,
            onValueChange = {setPassword(it)},
            modifier = Modifier
                .widthIn(max = 512.dp)
                .fillMaxWidth()
                .testTag("password"),
            label = {
                Text(text = "Password")
            },
            visualTransformation = PasswordVisualTransformation(),
            colors = textFieldColors,
            isError = isPasswordValid(password) != AuthInputError.OKAY && password.isNotEmpty(),
            supportingText = {
                if(isPasswordValid(password) != AuthInputError.OKAY && password.isNotEmpty())
                    ErrorMessage(
                        isPasswordValid(password),
                        isPassword = true
                    )
            }
        )

        if (confirmPassword!=null){
            OutlinedTextField(
                value = confirmPassword,
                onValueChange = {setConfirmPassword(it)},
                modifier = Modifier
                    .widthIn(max = 512.dp)
                    .fillMaxWidth()
                    .testTag("confirmPassword"),
                label = {
                    Text(text = "Confirm Password")
                },
                visualTransformation = PasswordVisualTransformation(),
                colors = textFieldColors,
                isError = password != confirmPassword,
                supportingText = {
                    if(password != confirmPassword)
                        Text(stringResource(R.string.passwords_must_match),modifier = Modifier.testTag("confirmPasswordError"))
                }
            )
        }


        BorderedButton(
            modifier = Modifier
                .align(Alignment.End)
                .testTag("login"),
            onClick = {

            },
            inverseColor = false,
            enabled = (
                    isPasswordValid(password) == AuthInputError.OKAY
                    && isUsernameValid(username) == AuthInputError.OKAY
                    && password.isNotEmpty() && username.isNotEmpty()
                    && (confirmPassword == password || confirmPassword == null)
                )
        ) {
            Text(
                text = if (confirmPassword==null)stringResource(R.string.login) else stringResource(R.string.sign_up),
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}