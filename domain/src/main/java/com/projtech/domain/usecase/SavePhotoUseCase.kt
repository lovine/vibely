package com.projtech.domain.usecase

import com.projtech.domain.repository.PhotoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SavePhotoUseCase(private val repository: PhotoRepository) {

    suspend operator fun invoke(path: String, emotion: String) {
        withContext(Dispatchers.IO) {
            repository.saveVibelyDayPhoto(path, emotion)
        }
    }
}