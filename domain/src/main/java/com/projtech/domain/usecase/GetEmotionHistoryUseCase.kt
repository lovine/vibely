package com.projtech.domain.usecase

import com.projtech.domain.model.UserHistoryPhotoEmotion
import com.projtech.domain.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class GetEmotionHistoryUseCase(private val repository: UserRepository) {

    suspend operator fun invoke(): Flow<List<UserHistoryPhotoEmotion>> {
        return repository.getUserEmotionHistory()
            .flowOn(Dispatchers.IO)
    }
}