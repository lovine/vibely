package com.projtech.data.mapper

import com.projtech.data.model.ContactDTO
import com.projtech.domain.model.Contact

fun ContactDTO.toDomain(): Contact =
    Contact(
        id = id,
        name = name,
        profilePictureUrl = profilePictureUrl,
        emotionPhotoOfDayUrl = emotionPhotoOfDayUrl,
        hasSeenPhoto = hasSeenPhoto
    )

fun Contact.toDTO(): ContactDTO =
    ContactDTO(
        id = id,
        name = name,
        profilePictureUrl = profilePictureUrl,
        emotionPhotoOfDayUrl = emotionPhotoOfDayUrl,
        hasSeenPhoto = hasSeenPhoto
    )