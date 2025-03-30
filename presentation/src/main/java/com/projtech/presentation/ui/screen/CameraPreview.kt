package com.projtech.presentation.ui.screen

import android.util.Log
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.projtech.core.utils.Dimens.PaddingSmall
import kotlinx.coroutines.launch
import timber.log.Timber
import java.io.File

@Composable
fun CameraPreview(
    emotion: String,
    onTakePhotoCliked: (String, String) -> Unit,
    onBackToHome: () -> Unit
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val coroutineScope = rememberCoroutineScope()

    val cameraProviderFuture = remember { ProcessCameraProvider.getInstance(context) }
    val previewView = remember { PreviewView(context).apply { scaleType = PreviewView.ScaleType.FILL_CENTER } }

    var imageCapture by remember { mutableStateOf<ImageCapture?>(null) }
    var cameraSelector by remember { mutableStateOf(CameraSelector.DEFAULT_BACK_CAMERA) }

    LaunchedEffect(cameraSelector) {
        val cameraProvider = cameraProviderFuture.get()

        val preview = Preview.Builder().build().also {
            it.setSurfaceProvider(previewView.surfaceProvider)
        }

        imageCapture = ImageCapture.Builder().build()

        try {
            cameraProvider.unbindAll()
            cameraProvider.bindToLifecycle(
                lifecycleOwner,
                cameraSelector,
                preview,
                imageCapture
            )
        } catch (exc: Exception) {
            Timber.e(exc, "Camera binding failed")
        }
    }

    AndroidView(
        factory = { previewView },
        modifier = Modifier.fillMaxSize()
    )

    Box(modifier = Modifier.fillMaxSize()) {

        val gradient = Brush.linearGradient(
            colors = listOf(Color(0xFF74EBD5), Color(0xFF8A75FF))
        )

        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 16.dp)
                .padding(PaddingSmall)
                .background(Color.Black.copy(alpha = 0.6f), RoundedCornerShape(PaddingSmall))
                .padding(horizontal = 12.dp, vertical = 4.dp)
        ) {
            Text(
                text = emotion,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    brush = gradient,
                    letterSpacing = 1.2.sp
                )
            )
        }

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 32.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            // Capture
            IconButton(
                onClick = {
                    val photoFile = File(context.cacheDir, "photo_${System.currentTimeMillis()}.jpg")
                    val outputOptions = ImageCapture.OutputFileOptions.Builder(photoFile).build()

                    imageCapture?.takePicture(
                        outputOptions,
                        ContextCompat.getMainExecutor(context),
                        object : ImageCapture.OnImageSavedCallback {
                            override fun onImageSaved(output: ImageCapture.OutputFileResults) {
                                coroutineScope.launch {
                                    onTakePhotoCliked(photoFile.absolutePath, emotion)
                                    onBackToHome()
                                }
                            }

                            override fun onError(exception: ImageCaptureException) {
                                Timber.e(exception, "Erreur lors de la capture")
                            }
                        }
                    )
                },
                modifier = Modifier
                    .size(72.dp)
                    .background(Color.White, CircleShape)
            ) {
                Icon(Icons.Default.Check, contentDescription = "Prendre la photo", tint = Color.Black)
            }

            IconButton(
                onClick = {
                    cameraSelector = if (cameraSelector == CameraSelector.DEFAULT_BACK_CAMERA) {
                        CameraSelector.DEFAULT_FRONT_CAMERA
                    } else {
                        CameraSelector.DEFAULT_BACK_CAMERA
                    }
                },
                modifier = Modifier
                    .size(56.dp)
                    .background(Color.Black.copy(alpha = 0.6f), CircleShape)
            ) {
                Icon(Icons.Default.Refresh, contentDescription = "Switch caméra", tint = Color.White)
            }
        }
    }
}