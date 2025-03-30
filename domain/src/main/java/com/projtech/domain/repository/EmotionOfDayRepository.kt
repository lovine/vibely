package com.projtech.domain.repository

import kotlinx.coroutines.flow.Flow

interface EmotionOfDayRepository {
    suspend fun getEmotionOfDay(): Flow<String>
}