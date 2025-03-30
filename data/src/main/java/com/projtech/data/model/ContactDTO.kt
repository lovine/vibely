package com.projtech.data.model

data class ContactDTO(
    val id: String,
    val name: String,
    val profilePictureUrl: String,
    val emotionPhotoOfDayUrl: String,
    var hasSeenPhoto: Boolean = false
)