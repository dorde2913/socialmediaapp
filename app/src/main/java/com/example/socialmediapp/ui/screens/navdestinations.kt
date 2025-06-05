package com.example.socialmediapp.ui.screens

interface NavDestination{
    val route: String

}

object GreetingDestination: NavDestination{
    override val route: String
        get() = "greeting"
}

object LoginDestination: NavDestination {
    override val route: String
        get() = "login"
}

object SignUpDestination: NavDestination {
    override val route: String
        get() = "register"
}
