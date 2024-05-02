package com.example.imovie.navigation

import android.util.Log
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.imovie.core.presentation.home.Homescreen
import com.example.imovie.core.presentation.settings.SettingsScreen
import com.example.imovie.navigation.components.BottomTabs

@Composable
fun TabScreens(
    navController: NavController
) {

    val bottomTabNav = rememberNavController()
    val currentRoute = rememberSaveable {
        mutableStateOf(Destination.Home.route)
    }
    val currentScreen  = bottomTabNav.currentScreenAsState()

    Scaffold(
        bottomBar = {
            BottomTabs(navController = bottomTabNav, selected = currentScreen, onClick = { route ->
                currentRoute.value = route
                bottomTabNav.navigate(route = route){
                    launchSingleTop = true
                    restoreState = true
                    popUpTo(bottomTabNav.graph.findStartDestination().id){
                        saveState = true
                    }
                }
            } )
        }
    ) {
        val padding = it
        NavHost(navController = bottomTabNav, startDestination = Destination.Home.route ){
            composable(route = Destination.Home.route){
                Homescreen(navController)
            }
            composable(route = Destination.Search.route){
//                SearchScreen()
            }

            composable(route = Destination.Favourites.route){
//                FavouritesScreen()
            }

            composable(route = Destination.Settings.route){
                SettingsScreen()
            }
        }
    }
}


@Stable
@Composable
private fun NavController.currentScreenAsState(): String {
    val selectedItem = remember {
        mutableStateOf(Destination.Home.route)
    }

    DisposableEffect(key1 = this){
        val listener = NavController.OnDestinationChangedListener{_, des, _ ->
            selectedItem.value = des.route!!
        }
        addOnDestinationChangedListener(listener)
        onDispose {
            removeOnDestinationChangedListener(listener)
        }
    }
    return selectedItem.value
}

