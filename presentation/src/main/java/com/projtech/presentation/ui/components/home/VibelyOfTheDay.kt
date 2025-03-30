package com.projtech.presentation.ui.components.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.projtech.core.utils.Dimens.CornerRadiusMedium
import com.projtech.core.utils.Dimens.PaddingLarge
import com.projtech.core.utils.Dimens.PaddingSmall
import com.projtech.domain.model.Photo

@Composable
fun VibelyOfTheDay(
    photo: Photo,
    modifier: Modifier = Modifier
) {
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val imageHeight = screenHeight * 0.65f // 65% de la hauteur écran

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(imageHeight)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.LightGray)
    ) {
        AsyncImage(
            model = photo.path,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(PaddingLarge)
                .background(Color.Black.copy(alpha = 0.6f), RoundedCornerShape(CornerRadiusMedium))
                .padding(horizontal = PaddingLarge, vertical = PaddingSmall)
        ) {
            Text(
                text = photo.emotion,
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )
        }
    }
}