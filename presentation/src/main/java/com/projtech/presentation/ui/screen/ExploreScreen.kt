package com.projtech.presentation.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.projtech.core.utils.Dimens.PaddingLarge
import com.projtech.presentation.ui.components.explorer.PhotoEmotionItem
import com.projtech.presentation.viewmodel.ExploreViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ExploreScreen(viewModel: ExploreViewModel = koinViewModel()) {
    val photos = viewModel.explorePhotos.collectAsState().value

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Explorer la Vibely du jour",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(PaddingLarge)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(photos) { photo ->
                PhotoEmotionItem(photo = photo)
            }
        }
    }
}
