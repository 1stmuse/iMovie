package com.example.imovie.core.presentation.settings

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.ui.graphics.vector.ImageVector

data class SettingsOption(val label: String, val icon: ImageVector)


object SettingsOptions {

    val options = listOf<SettingsOption>(
        SettingsOption("Account", Icons.Default.AccountCircle),
        SettingsOption("Privacy", Icons.Default.Lock),
        SettingsOption("Notifications", Icons.Default.Notifications),
        SettingsOption("Helo", Icons.Default.Info),
    )
}