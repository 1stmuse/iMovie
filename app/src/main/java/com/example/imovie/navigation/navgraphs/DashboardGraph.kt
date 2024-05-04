package com.example.imovie.navigation.navgraphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.imovie.movieDetail.presentation.MovieDetailScreen
import com.example.imovie.navigation.Dashboard_Graph
import com.example.imovie.navigation.Destination
import com.example.imovie.navigation.TabScreen
import com.example.imovie.navigation.TabScreens

fun NavGraphBuilder.dashbaordGraph(
    navController: NavHostController
){
    navigation(startDestination = TabScreen, route= Dashboard_Graph){
        composable(route = TabScreen){
            TabScreens(navController = navController)
        }
        composable(route = Destination.MovieDetail.route, arguments = listOf(
            navArgument("movieId") { type = NavType.StringType }
        )){ navBackStackEntry ->
            val movieId = navBackStackEntry.arguments?.getString("movieId")
            MovieDetailScreen(navController, movieId = movieId!!)
        }

    }
}