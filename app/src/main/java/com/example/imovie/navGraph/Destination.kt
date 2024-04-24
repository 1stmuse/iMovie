package com.example.imovie.navGraph

sealed class Destination(val route: String) {

    object Onboarding : Destination("onboarding")
    object Login : Destination("login")
    object Signup : Destination("signup")
    object Dashboard : Destination("dashboard")
}