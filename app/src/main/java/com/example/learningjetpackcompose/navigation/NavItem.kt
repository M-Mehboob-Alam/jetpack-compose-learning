package com.example.learningjetpackcompose.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings


sealed class NavItem {
    object Home : Item(
        NavRoute.Home.path.toString(),
        "Home",
        Icons.Default.Home
    )

    object Profile : Item(
        NavRoute.Profile.path.toString(),
        "Profile",
        Icons.Default.Person
    )

    object Settings : Item(
        NavRoute.Settings.path.toString(),
        "Settings",
        Icons.Default.Settings
    )


}