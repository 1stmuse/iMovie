package com.example.imovie.navigation


const val Auth_Graph = "AUTH"
const val Dashboard_Graph = "DASHBOARD"

const val TabScreen = "TAB_SCREEN"

sealed class Destination(val route: String) {

    object Onboarding : Destination("onboarding")
    object Login : Destination("login")
    object Signup : Destination("signup")
    object Home : Destination("home")

    object Search: Destination("search")

    object Favourites: Destination("favourites")
    object Settings: Destination("settings")
}