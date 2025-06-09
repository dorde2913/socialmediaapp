package com.example.socialmediapp.ui.screens.authentication.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import com.example.socialmediapp.R

val usernameRegex = "^[a-zA-Z0-9]+$".toRegex()
val passwordRegex = "^[a-zA-Z0-9!@#\$%^&*]+$".toRegex()


enum class AuthInputError(val value: Int){
    OKAY(0),
    INVALID_CHARACTERS(1),
    BAD_LENGTH(2),
    IS_BLANK(3)
}

fun isUsernameValid(username: String): AuthInputError {
    if (username.isBlank()) return AuthInputError.IS_BLANK
    if (username.length !in 5 until 26) return AuthInputError.BAD_LENGTH
    return if(username.matches(usernameRegex)) AuthInputError.OKAY else AuthInputError.INVALID_CHARACTERS
}

@Composable
fun ErrorMessage(
    error: AuthInputError,
    isPassword: Boolean
){
    val usernameErrorMessages = mapOf(
        AuthInputError.OKAY to "",
        AuthInputError.IS_BLANK to stringResource(R.string.username_cannot_be_blank),
        AuthInputError.BAD_LENGTH to stringResource(R.string.username_length_error_msg),
        AuthInputError.INVALID_CHARACTERS to stringResource(R.string.username_invalid_character_error)
    )
    val passwordErrorMessages = mapOf(
        AuthInputError.OKAY to "",
        AuthInputError.IS_BLANK to stringResource(R.string.password_cannot_be_blank),
        AuthInputError.BAD_LENGTH to stringResource(R.string.password_length_error),
        AuthInputError.INVALID_CHARACTERS to stringResource(R.string.password_invalid_char_error)
    )

    Text(
        text = if (isPassword) passwordErrorMessages[error]?: "" else usernameErrorMessages[error] ?: "",
        modifier = Modifier.testTag(if (isPassword) "passwordError" else "userNameError")
    )
}

fun isPasswordValid(password: String): AuthInputError {
    if (password.isBlank()) return AuthInputError.IS_BLANK
    if (password.length !in 5 until 26) return AuthInputError.BAD_LENGTH
    return if(password.matches(passwordRegex)) AuthInputError.OKAY else AuthInputError.INVALID_CHARACTERS
}