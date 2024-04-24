package com.example.imovie.navGraph

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.imovie.auth.login.LoginScreen
import com.example.imovie.auth.OnboardingScreen
import com.example.imovie.auth.signup.SignupScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun IMovie(startDestination: String) {

    val navController =  rememberNavController()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 0.dp)
        ) {
            NavHost(navController = navController, startDestination = startDestination){
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

}