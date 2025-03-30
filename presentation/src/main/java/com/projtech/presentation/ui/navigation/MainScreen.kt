package com.projtech.presentation.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.projtech.presentation.ui.components.VibelyHeader
import com.projtech.presentation.ui.screen.ExploreScreen
import com.projtech.presentation.ui.screen.HomeScreen
import com.projtech.presentation.ui.screen.PhotoScreen
import com.projtech.presentation.viewmodel.HomeViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainScreen(viewModel: HomeViewModel = koinViewModel()) {
    val navController = rememberNavController()
    val contacts by viewModel.contacts.collectAsState()

    Scaffold(
        topBar = { VibelyHeader() },
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = ScreenNav.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(ScreenNav.Home.route) {
                HomeScreen(navController)
            }
            composable(ScreenNav.Photo.route) {
                PhotoScreen(
                    onBackToHome = { navController.popBackStack() }
                )
            }
            composable(ScreenNav.Discover.route) {
                ExploreScreen()
            }
        }
    }
}