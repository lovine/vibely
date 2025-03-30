package com.projtech.data.repository

import com.projtech.domain.repository.EmotionOfDayRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class EmotionOfDayRepositoryImpl: EmotionOfDayRepository {
    override suspend fun getEmotionOfDay(): Flow<String> = flow {
        emit("Nostalgie d’un moment")
    }
}