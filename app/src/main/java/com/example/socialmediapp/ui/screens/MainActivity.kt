package com.example.socialmediapp.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.socialmediapp.ui.screens.authentication.GreetingScreen
import com.example.socialmediapp.ui.screens.authentication.LoginScreen
import com.example.socialmediapp.ui.screens.authentication.SignupScreen
import com.example.socialmediapp.ui.theme.SocialmediAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SocialmediAppTheme {
                SocialMediaApp()
            }
        }
    }
}

@Composable
fun SocialMediaApp(){
    val context = LocalContext.current

    val navController = rememberNavController()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStackEntry?.destination

    val navigateToLogin = {
        navController.myNavigate(LoginDestination.route)
    }
    val navigateToSignUp = {
        navController.myNavigate(SignUpDestination.route)
    }

    NavHost(
        navController = navController,
        startDestination = GreetingDestination.route//tbc
    ){
        composable(
            route = GreetingDestination.route
        ){
            GreetingScreen(
                navigateToLogin,
                navigateToSignUp
            )
        }

        composable(
            route = LoginDestination.route
        ){
            LoginScreen()
        }

        composable(
            route = SignUpDestination.route
        ){
            SignupScreen()
        }
    }

}

fun NavController.myNavigate(route: String) {
    navigate(route){
        launchSingleTop = true
        restoreState = true
    }
}