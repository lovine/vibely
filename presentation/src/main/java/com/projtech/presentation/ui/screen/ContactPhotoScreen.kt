package com.projtech.presentation.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.projtech.core.utils.Dimens.CornerRadiusSmall
import com.projtech.core.utils.Dimens.PaddingLarge
import com.projtech.core.utils.Dimens.PaddingSmall
import com.projtech.domain.model.Contact

@Composable
fun ContactPhotoScreen(
    contact: Contact,
    markPhotoAsSeen: (String) -> Unit,
    onBack: () -> Unit,
) {
    LaunchedEffect(Unit) {
        markPhotoAsSeen(contact.id)
    }

    Box(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxSize()
    ) {
        AsyncImage(
            model = contact.emotionPhotoOfDayUrl,
            contentDescription = "Photo émotion",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
        )

        Surface(
            color = Color.Black.copy(alpha = 0.6f),
            shape = RoundedCornerShape(CornerRadiusSmall),
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(PaddingSmall)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(horizontal = PaddingSmall, vertical = 4.dp)
            ) {
                AsyncImage(
                    model = contact.profilePictureUrl,
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                        .clip(RoundedCornerShape(4.dp)),
                    contentScale = ContentScale.Crop
                )
                Text(
                    modifier = Modifier.padding(start = PaddingSmall),
                    text = contact.name,
                    color = Color.White,
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    modifier = Modifier.padding(end = PaddingSmall),
                    text = " ${contact.id}",
                    color = Color.White,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        IconButton(
            onClick = onBack,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(PaddingLarge)
                .background(Color.Black.copy(alpha = 0.6f), shape = CircleShape)
        ) {
            Icon(
                Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Retour",
                tint = Color.White
            )
        }
    }
}