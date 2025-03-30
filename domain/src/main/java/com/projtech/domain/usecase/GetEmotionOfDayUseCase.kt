package com.projtech.domain.usecase

import com.projtech.domain.repository.EmotionOfDayRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class GetEmotionOfDayUseCase(private val repository: EmotionOfDayRepository) {

    suspend operator fun invoke(): Flow<String> {
        return repository.getEmotionOfDay()
            .flowOn(Dispatchers.IO)
    }
}