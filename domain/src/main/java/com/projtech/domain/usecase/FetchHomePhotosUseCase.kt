package com.projtech.domain.usecase

import com.projtech.domain.model.Photo
import com.projtech.domain.repository.PhotoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class FetchVibelyDayPhotoUseCase(private val repository: PhotoRepository) {

    suspend operator fun invoke(): Flow<Photo?> {
        return repository.getVibelyDayPhoto()
            .flowOn(Dispatchers.IO)
    }
}