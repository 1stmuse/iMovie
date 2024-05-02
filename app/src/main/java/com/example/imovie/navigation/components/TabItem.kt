package com.example.imovie.navigation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.imovie.navigation.Destination

data class TabItem(val route: String, val label: String, var icon: ImageVector)


object Tabs {
    val tabList = listOf<TabItem>(
        TabItem(Destination.Home.route ,"Home", Icons.Default.Home),
        TabItem(Destination.Search.route,"Search", Icons.Default.Search),
        TabItem(Destination.Favourites.route,"Favourites", Icons.Default.Favorite),
        TabItem(Destination.Settings.route,"Settings", Icons.Default.Settings),
    )
}

