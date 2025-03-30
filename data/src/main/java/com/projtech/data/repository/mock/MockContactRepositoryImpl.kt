package com.projtech.data.repository.mock

import com.projtech.data.mapper.toDomain
import com.projtech.data.model.ContactDTO
import com.projtech.domain.model.Contact
import com.projtech.domain.repository.ContactRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MockContactRepositoryImpl : ContactRepository {
    override fun fetchContacts(): Flow<List<Contact>> = flow {
        val listOfContact =  listOf(
            ContactDTO(
                id = "@contact005",
                name = "Emma",
                profilePictureUrl = "https://randomuser.me/api/portraits/women/28.jpg",
                emotionPhotoOfDayUrl = "https://picsum.photos/400/400?random=105",
                hasSeenPhoto = false
            ),
            ContactDTO(
                id = "@contact007",
                name = "Lucas",
                profilePictureUrl = "https://randomuser.me/api/portraits/men/22.jpg",
                emotionPhotoOfDayUrl = "https://picsum.photos/400/400?random=107",
                hasSeenPhoto = false
            ),
            ContactDTO(
                id = "@contact003",
                name = "Léa",
                profilePictureUrl = "https://randomuser.me/api/portraits/women/82.jpg",
                emotionPhotoOfDayUrl = "https://picsum.photos/400/400?random=103",
                hasSeenPhoto = false
            ),
            ContactDTO(
                id = "@contact004",
                name = "Gabriel",
                profilePictureUrl = "https://randomuser.me/api/portraits/men/4.jpg",
                emotionPhotoOfDayUrl = "https://picsum.photos/400/400?random=104",
                hasSeenPhoto = false
            ),
            ContactDTO(
                id = "@contact001",
                name = "Alice",
                profilePictureUrl = "https://randomuser.me/api/portraits/women/10.jpg",
                emotionPhotoOfDayUrl = "https://picsum.photos/400/400?random=101",
                hasSeenPhoto = false
            ),
            ContactDTO(
                id = "@contact002",
                name = "Thomas",
                profilePictureUrl = "https://randomuser.me/api/portraits/men/72.jpg",
                emotionPhotoOfDayUrl = "https://picsum.photos/400/400?random=102",
                hasSeenPhoto = false
            ),
            ContactDTO(
                id = "@contact006",
                name = "Nina",
                profilePictureUrl = "https://randomuser.me/api/portraits/women/21.jpg",
                emotionPhotoOfDayUrl = "https://picsum.photos/400/400?random=106",
                hasSeenPhoto = false
            ),
            ContactDTO(
                id = "@contact008",
                name = "Chloé",
                profilePictureUrl = "https://randomuser.me/api/portraits/women/23.jpg",
                emotionPhotoOfDayUrl = "https://picsum.photos/400/400?random=108",
                hasSeenPhoto = false
            ),
            ContactDTO(
                id = "@contact009",
                name = "Ethan",
                profilePictureUrl = "https://randomuser.me/api/portraits/men/24.jpg",
                emotionPhotoOfDayUrl = "https://picsum.photos/400/400?random=109",
                hasSeenPhoto = false
            ),
            ContactDTO(
                id = "@contact010",
                name = "Camille",
                profilePictureUrl = "https://randomuser.me/api/portraits/women/25.jpg",
                emotionPhotoOfDayUrl = "https://picsum.photos/400/400?random=110",
                hasSeenPhoto = false
            )
        ).map { it.toDomain() }
        emit(listOfContact)
    }
}