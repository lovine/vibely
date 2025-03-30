package com.projtech.presentation.ui.components.home

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun VibelyDay(emotion: String) {
    val gradient = Brush.linearGradient(
        colors = listOf(Color(0xFF74EBD5), Color(0xFF8A75FF))
    )

    val alphaAnim = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        alphaAnim.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 800)
        )
    }

    Text(
        text = emotion,
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            brush = gradient,
            letterSpacing = 1.2.sp
        ),
        modifier = Modifier
            .padding(vertical = 16.dp)
            .alpha(alphaAnim.value),
        textAlign = TextAlign.Center
    )
}