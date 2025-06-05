package com.example.socialmediapp

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.NavController
import com.example.socialmediapp.ui.screens.LoginDestination
import com.example.socialmediapp.ui.screens.SignUpDestination

import com.example.socialmediapp.ui.screens.authentication.GreetingScreen
import com.example.socialmediapp.ui.theme.SocialmediAppTheme
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class AuthScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

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
}