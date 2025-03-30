package com.projtech.domain.model

data class Contact(
    val id: String,
    val name: String,
    val profilePictureUrl: String,
    val emotionPhotoOfDayUrl: String,
    var hasSeenPhoto: Boolean = false
)