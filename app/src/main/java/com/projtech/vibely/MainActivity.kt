package com.projtech.vibely

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.projtech.presentation.ui.navigation.MainScreen
import com.projtech.presentation.ui.screen.HomeScreen
import com.projtech.presentation.viewmodel.HomeViewModel
import com.projtech.vibely.theme.VibelyTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VibelyTheme {
                MainScreen()
            }
        }
    }
}