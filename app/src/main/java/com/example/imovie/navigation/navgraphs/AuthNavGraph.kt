package com.example.imovie.navigation.navgraphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.imovie.auth.OnboardingScreen
import com.example.imovie.auth.login.LoginScreen
import com.example.imovie.auth.signup.SignupScreen
import com.example.imovie.navigation.Auth_Graph
import com.example.imovie.navigation.Destination


fun NavGraphBuilder.authNavGraph(
    navController: NavHostController
){

    navigation(
        startDestination = Destination.Onboarding.route,
        route = Auth_Graph
    ){
        composable(route = Destination.Onboarding.route){
            OnboardingScreen(navController)
        }
        composable(route = Destination.Login.route){
            LoginScreen(navController)
        }
        composable(route = Destination.Signup.route){
            SignupScreen(navController)
        }
    }
}