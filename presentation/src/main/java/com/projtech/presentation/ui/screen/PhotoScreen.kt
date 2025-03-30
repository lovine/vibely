package com.projtech.presentation.ui.screen

import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import com.projtech.presentation.viewmodel.PhotoScreenViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun PhotoScreen(
    onBackToHome: () -> Unit,
    viewModel: PhotoScreenViewModel = koinViewModel()
) {
    val emotion by viewModel.emotion.collectAsState()

    val context = LocalContext.current

    var hasCameraPermission by remember {
        mutableStateOf(
            ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED
        )
    }

    val launcher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { granted ->
        hasCameraPermission = granted
    }

    LaunchedEffect(Unit) {
        if (!hasCameraPermission) {
            launcher.launch(Manifest.permission.CAMERA)
        }
    }

    if (hasCameraPermission) {
        CameraPreview(
            emotion = emotion,
            onTakePhotoCliked = { path, emotion -> viewModel.savePhoto(path, emotion) },
            onBackToHome = { onBackToHome() }
        )
    } else {
        Text("Permission caméra requise")
    }
}