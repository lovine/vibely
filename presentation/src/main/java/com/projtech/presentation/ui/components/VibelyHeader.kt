package com.projtech.presentation.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.projtech.presentation.R

@Composable
fun VibelyHeader(
    modifier: Modifier = Modifier
) {
    val meowFont = FontFamily(
        Font(R.font.meow_regular, FontWeight.Normal)
    )

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.vibely_new),
            contentDescription = "Logo Vibely",
            modifier = Modifier.size(35.dp),
            tint = Color.Unspecified
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = "Vibely",
            style = MaterialTheme.typography.headlineLarge.copy(
                fontWeight = FontWeight.Bold,
                fontFamily = meowFont,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        )
    }
}