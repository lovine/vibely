package com.projtech.data.repository.mock

import com.projtech.domain.model.UserHistoryPhotoEmotion
import com.projtech.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MockUserRepositoryImpl: UserRepository {

    override suspend fun getUserEmotionHistory(): Flow<List<UserHistoryPhotoEmotion>> {
        return flow {
            val listUserEmotionHistory = listOf(
                UserHistoryPhotoEmotion("Hier", "https://picsum.photos/id/65/600/600", "Coucher de soleil"),
                UserHistoryPhotoEmotion("Avant-hier", "https://picsum.photos/600?1", "Sérénité matinale"),
                UserHistoryPhotoEmotion("28/03/2025", "https://picsum.photos/id/180/600/600", "Jour de pluie"),
                UserHistoryPhotoEmotion("27/03/2025", "https://picsum.photos/id/177/600/600", "Plonger dans l'inconnu"),
                UserHistoryPhotoEmotion("27/03/2025", "https://picsum.photos/id/239/600/600", "Peur irrationnelle")
            )
            emit(listUserEmotionHistory)
        }
    }
}