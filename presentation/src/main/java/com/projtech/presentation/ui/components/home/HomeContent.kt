package com.projtech.presentation.ui.components.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.projtech.core.utils.Dimens.PaddingLarge
import com.projtech.domain.model.Photo
import com.projtech.domain.model.UserHistoryPhotoEmotion

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    vibelyDayPhoto: Photo?,
    userHistory: List<UserHistoryPhotoEmotion>,
    emotionDay: String,
    onTakePhotoClicked: () -> Unit
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        item {
            vibelyDayPhoto?.let { photo ->
                VibelyOfTheDay(photo)
            } ?: run {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFEEEAFD))
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(PaddingLarge),
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        VibelyDay(emotion = emotionDay)
                        HomeTakePhotoButton(onClick = onTakePhotoClicked)
                    }
                }
            }
        }

        items(userHistory) { photo ->
            EmotionHistoryItem(photo = photo)
        }
    }
}