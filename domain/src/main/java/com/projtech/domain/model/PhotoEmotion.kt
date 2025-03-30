package com.projtech.domain.model

data class PhotoEmotion(
    val profilAccountId: String,
    val profilName: String,
    val profilePictureUrl: String,
    val imageUrl: String,
    val emotion: String,
)