package com.projtech.presentation.ui.components.contact

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.projtech.core.utils.Dimens.CornerRadiusSmall
import com.projtech.domain.model.Contact

@Composable
fun ContactCard(
    contact: Contact,
    onContactClick: () -> Unit
) {

    val borderWidth by animateDpAsState(
        targetValue = if (!contact.hasSeenPhoto) 3.dp else 0.dp,
        animationSpec = tween(durationMillis = 500)
    )

    val borderColor by animateColorAsState(
        targetValue = if (!contact.hasSeenPhoto) Color(0xFF8A75FF) else Color.Transparent,
        animationSpec = tween(durationMillis = 500)
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(72.dp)
            .clickable { onContactClick() }
    ) {
        Box(
            modifier = Modifier
                .size(72.dp)
                .clip(RoundedCornerShape(CornerRadiusSmall))
                .border(
                    width = borderWidth,
                    color = borderColor,
                    shape = RoundedCornerShape(CornerRadiusSmall)
                )
        ) {
            AsyncImage(
                model = contact.profilePictureUrl,
                contentDescription = contact.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = contact.name,
            style = MaterialTheme.typography.labelSmall,
            color = Color.Black,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}