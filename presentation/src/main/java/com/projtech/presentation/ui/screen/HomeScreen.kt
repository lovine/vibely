package com.projtech.presentation.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.projtech.presentation.ui.components.contact.ContactStoriesSection
import com.projtech.presentation.ui.components.home.HomeContent
import com.projtech.presentation.ui.navigation.ScreenNav
import com.projtech.presentation.viewmodel.HomeViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = koinViewModel()
) {
    val scope = rememberCoroutineScope()

    val emotionDay by viewModel.emotion.collectAsState()
    val vibelyDayPhoto by viewModel.vibelyDayPhoto.collectAsState()
    val contacts by viewModel.contacts.collectAsState()
    val userHistory by viewModel.userHistoryEmotion.collectAsState()
    val selectedContact by viewModel.selectedContact.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getVibelyDayPhoto()
    }

    val sheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        skipHalfExpanded = true,
        confirmValueChange = { true }
    )

    ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetContent = {
            selectedContact?.let {
                ContactPhotoScreen(
                    contact = it,
                    markPhotoAsSeen = { contacts -> viewModel.markPhotoAsSeen(contacts) }
                ) {
                    scope.launch {
                        sheetState.hide()
                        viewModel.clearSelectedContact()
                    }
                }
            }
        }
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Divider(
                    color = Color(0xFFE0E0E0), // gris doux
                    thickness = 1.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                ContactStoriesSection(contacts = contacts) { selectedContact ->
                    viewModel.selectContact(selectedContact)
                    scope.launch {
                        delay(300)
                        sheetState.show()
                    }
                }

                HomeContent(
                    vibelyDayPhoto = vibelyDayPhoto,
                    userHistory = userHistory,
                    emotionDay = emotionDay,
                    onTakePhotoClicked = {
                        navController.navigate(ScreenNav.Photo.route)
                     })
            }
        }
    }
}