package com.projtech.domain.repository

import com.projtech.domain.model.UserHistoryPhotoEmotion
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun getUserEmotionHistory(): Flow<List<UserHistoryPhotoEmotion>>
}