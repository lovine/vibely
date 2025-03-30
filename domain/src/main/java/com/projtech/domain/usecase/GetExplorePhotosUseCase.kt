package com.projtech.domain.usecase

import com.projtech.domain.model.PhotoEmotion
import com.projtech.domain.repository.PhotoRepository
import kotlinx.coroutines.flow.Flow

class GetExplorePhotosUseCase(private val repository: PhotoRepository) {

    suspend operator fun invoke(): Flow<List<PhotoEmotion>> = repository.getExplorerRandomPhotos()
}