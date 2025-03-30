package com.projtech.presentation.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ScreenNav(
    val route: String,
    val icon: ImageVector,
    val label: String
) {
    object Home : ScreenNav("home", Icons.Default.Home, "Home")
    object Photo : ScreenNav("photo", Icons.Default.AddCircle, "Photo")
    object Discover : ScreenNav("discover", Icons.Default.Search, "Discover")
}