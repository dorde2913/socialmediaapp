package com.example.socialmediapp

import android.content.Context
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.assertValueEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.navigation.NavController
import androidx.test.core.app.ApplicationProvider
import com.example.socialmediapp.ui.screens.LoginDestination
import com.example.socialmediapp.ui.screens.SignUpDestination

import com.example.socialmediapp.ui.screens.authentication.GreetingScreen
import com.example.socialmediapp.ui.screens.authentication.LoginScreen
import com.example.socialmediapp.ui.screens.authentication.SignupScreen
import com.example.socialmediapp.ui.theme.SocialmediAppTheme
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class AuthScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    val context = ApplicationProvider.getApplicationContext<Context>()

    lateinit var navController: NavController

    @Before
    fun setUp(){
        navController = mockk<NavController>(relaxed = true)
    }



    @Test
    fun pressingLoginNavigatesToLoginScreen(){
        composeTestRule.setContent {
            SocialmediAppTheme {
                GreetingScreen(
                    onSignUpPress = {
                        navController.navigate(SignUpDestination.route)
                    },
                    onLoginPress = {
                        navController.navigate(LoginDestination.route)
                    }
                )
            }
        }

        composeTestRule.onNodeWithText("Login").performClick()

        verify {
            navController.navigate(LoginDestination.route)
        }
    }


    @Test
    fun pressingSignUpNavigatesToSignUpScreen(){
        composeTestRule.setContent {
            SocialmediAppTheme {
                GreetingScreen(
                    onSignUpPress = {
                        navController.navigate(SignUpDestination.route)
                    },
                    onLoginPress = {
                        navController.navigate(LoginDestination.route)
                    }
                )
            }
        }

        composeTestRule.onNodeWithText("Sign up").performClick()

        verify {
            navController.navigate(SignUpDestination.route)
        }
    }


    fun assertLoginButtonEnabled(username: String, password: String) {
        composeTestRule.setContent {
            SocialmediAppTheme {
                LoginScreen()
            }
        }

        composeTestRule.onNodeWithTag("username")
            .performTextInput(username)
        composeTestRule.onNodeWithTag("password")
            .performTextInput(password)

        composeTestRule.waitForIdle()

        composeTestRule.onNodeWithTag("login")
            .assertIsEnabled()
    }

    fun assertLoginButtonDisabled(username: String, password: String) {
        composeTestRule.setContent {
            SocialmediAppTheme {
                LoginScreen()
            }
        }

        composeTestRule.onNodeWithTag("username")
            .performTextInput(username)
        composeTestRule.onNodeWithTag("password")
            .performTextInput(password)

        composeTestRule.waitForIdle()

        composeTestRule.onNodeWithTag("login")
            .assertIsNotEnabled()
    }

    fun assertErrorMessageDisplayed(username: String,password: String,errorMessage: String,isPassword: Boolean){
        composeTestRule.setContent {
            SocialmediAppTheme {
                LoginScreen()
            }
        }
        composeTestRule.onNodeWithTag("username")
            .performTextInput(username)

        composeTestRule.onNodeWithTag("password")
            .performTextInput(password)

        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithTag(if (isPassword) "passwordError" else "userNameError", useUnmergedTree = true)
            .assertTextEquals(errorMessage)
    }



    @Test
    fun validCredentialsEnableLoginButton() =
        assertLoginButtonEnabled("Dorde123","Password!123")


    @Test
    fun emptyCredentialsDisableLoginButton() =
        assertLoginButtonDisabled("","")


    @Test
    fun shortUsernameDisablesLoginButton() =
        assertLoginButtonDisabled(username = "adbc", password = "Password!123")

    @Test
    fun blankUsernameDisablesLoginButton() =
        assertLoginButtonDisabled(username = "       ", password = "Password!123")


    @Test
    fun longUsernameDisablesLoginButton() =
        assertLoginButtonDisabled(username = "abcdlakjhlakjfhkljhasflkjahfklajhlkjhlkjhkjh", password = "Password!123")


    @Test
    fun invalidUsernameDisablesLoginButton() =
        assertLoginButtonDisabled(username = "abcd!!!!", password = "Password!123")


    @Test
    fun shortUsernameDisplaysErrorMessage() =
        assertErrorMessageDisplayed(username = "abcd", password = "Password!123"
            , errorMessage = context.getString(R.string.username_length_error_msg),isPassword = false)


    @Test
    fun longUsernameDisplaysErrorMessage() =
        assertErrorMessageDisplayed(username = "abcdlakjhlakjfhkljhasflkjahfklajhlkjhlkjhkjh", password = "Password!123"
            , errorMessage = context.getString(R.string.username_length_error_msg),isPassword = false)

    @Test
    fun invalidUsernameDisplaysErrorMessage() =
        assertErrorMessageDisplayed(username = "Password!!!!!!!", password = "Password!123"
            , errorMessage = context.getString(R.string.username_invalid_character_error),isPassword = false)

    @Test
    fun blankUsernameDisplaysErrorMessage() =
        assertErrorMessageDisplayed(username = "       ", password = "Password!123"
            , errorMessage = context.getString(R.string.username_cannot_be_blank),isPassword = false)

    @Test
    fun blankPasswordDisablesLoginButton() =
        assertLoginButtonDisabled(username = "Dorde", password = "      ")

    @Test
    fun shortPasswordDisablesLoginButton() =
        assertLoginButtonDisabled(username = "Dorde", password = "buh")

    @Test
    fun longPasswordDisablesLoginButton() =
        assertLoginButtonDisabled(username = "Dorde", password = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA")

    @Test
    fun invalidPasswordDisablesLoginButton() =
        assertLoginButtonDisabled(username = "Dorde", password = "<><><><>><>")

    @Test
    fun blankPasswordDisplaysErrorMessage() =
        assertErrorMessageDisplayed(username = "Dorde", password = "      ",
            errorMessage = context.getString(R.string.password_cannot_be_blank),isPassword = true)

    @Test
    fun shortPasswordDisplaysErrorMessage() =
        assertErrorMessageDisplayed(username = "Dorde", password = "abc",
            errorMessage = context.getString(R.string.password_length_error),isPassword = true)

    @Test
    fun longPasswordDisplaysErrorMessage() =
        assertErrorMessageDisplayed(username = "Dorde", password = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA",
            errorMessage = context.getString(R.string.password_length_error),isPassword = true)

    @Test
    fun invalidPasswordDisplaysErrorMessage() =
        assertErrorMessageDisplayed(username = "Dorde", password = "<><><{}{}{",
            errorMessage = context.getString(R.string.password_invalid_char_error),isPassword = true)


    @Test
    fun passwordsNotMatchingDisablesSignUpButton(){
        composeTestRule.setContent {
            SocialmediAppTheme {
                SignupScreen()
            }
        }

        composeTestRule.onNodeWithTag("username")
            .performTextInput("Dorde123")
        composeTestRule.onNodeWithTag("password")
            .performTextInput("Password!123")
        composeTestRule.onNodeWithTag("confirmPassword")
            .performTextInput("abcd123")

        composeTestRule.waitForIdle()

        composeTestRule.onNodeWithTag("login")
            .assertIsNotEnabled()
    }

    @Test
    fun passwordsNotMatchingDisplaysErrorMessage(){
        composeTestRule.setContent {
            SocialmediAppTheme {
                SignupScreen()
            }
        }
        composeTestRule.onNodeWithTag("username")
            .performTextInput("Dorde123")
        composeTestRule.onNodeWithTag("password")
            .performTextInput("Password!123")
        composeTestRule.onNodeWithTag("confirmPassword")
            .performTextInput("abcd123")

        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithTag("confirmPasswordError", useUnmergedTree = true)
            .assertTextEquals(context.getString(R.string.passwords_must_match))
    }
}