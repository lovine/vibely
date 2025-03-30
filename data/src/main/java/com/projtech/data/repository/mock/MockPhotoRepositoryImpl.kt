package com.projtech.data.repository.mock

import com.projtech.data.mapper.toDTO
import com.projtech.data.mapper.toDomain
import com.projtech.data.model.PhotoDTO
import com.projtech.data.model.PhotoEmotionDTO
import com.projtech.domain.model.Photo
import com.projtech.domain.model.PhotoEmotion
import com.projtech.domain.repository.PhotoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.UUID

class MockPhotoRepositoryImpl : PhotoRepository {
    private var photoDay: PhotoDTO? = null

    override suspend fun saveVibelyDayPhoto(path: String, emotion: String) {
        photoDay =
            Photo(
                id = UUID.randomUUID().toString(),
                path = path,
                emotion = emotion,
                timestamp = System.currentTimeMillis()
            ).toDTO()
    }

    override suspend fun getVibelyDayPhoto(): Flow<Photo?> {
        return flow {
            emit(photoDay?.toDomain())
        }
    }

    override suspend fun getExplorerRandomPhotos(): Flow<List<PhotoEmotion>> {
        return flow {
            val listofPhotos = listOf(
                PhotoEmotionDTO(
                    profilAccountId = "user001",
                    profilName = "Alice",
                    profilePictureUrl = "https://randomuser.me/api/portraits/women/1.jpg",
                    imageUrl = "https://picsum.photos/400/400?random=1",
                    emotion = "Surprise au réveil"
                ),
                PhotoEmotionDTO(
                    profilAccountId = "user002",
                    profilName = "Lucas",
                    profilePictureUrl = "https://randomuser.me/api/portraits/men/2.jpg",
                    imageUrl = "https://picsum.photos/400/400?random=2",
                    emotion = "Surprise au réveil"
                ),
                PhotoEmotionDTO(
                    profilAccountId = "user003",
                    profilName = "Chloé",
                    profilePictureUrl = "https://randomuser.me/api/portraits/women/3.jpg",
                    imageUrl = "https://picsum.photos/400/400?random=3",
                    emotion = "Surprise au réveil"
                ),
                PhotoEmotionDTO(
                    profilAccountId = "user004",
                    profilName = "Maxime",
                    profilePictureUrl = "https://randomuser.me/api/portraits/men/4.jpg",
                    imageUrl = "https://picsum.photos/400/400?random=4",
                    emotion = "Surprise au réveil"
                ),
                PhotoEmotionDTO(
                    profilAccountId = "user005",
                    profilName = "Emma",
                    profilePictureUrl = "https://randomuser.me/api/portraits/women/5.jpg",
                    imageUrl = "https://picsum.photos/400/400?random=5",
                    emotion = "Surprise au réveil"
                )
            ).map { it.toDomain() }
            emit(listofPhotos)
        }
    }
}