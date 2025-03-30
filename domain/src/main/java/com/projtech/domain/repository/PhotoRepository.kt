package com.projtech.domain.repository

import com.projtech.domain.model.Photo
import com.projtech.domain.model.PhotoEmotion
import kotlinx.coroutines.flow.Flow


interface PhotoRepository {
    suspend fun saveVibelyDayPhoto(path: String, emotion: String)
    suspend fun getVibelyDayPhoto(): Flow<Photo?>
    suspend fun getExplorerRandomPhotos(): Flow<List<PhotoEmotion>>
}