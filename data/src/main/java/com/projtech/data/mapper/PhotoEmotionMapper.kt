package com.projtech.data.mapper

import com.projtech.data.model.PhotoEmotionDTO
import com.projtech.domain.model.PhotoEmotion

fun PhotoEmotionDTO.toDomain(): PhotoEmotion =
    PhotoEmotion(
        profilAccountId = profilAccountId,
        profilName = profilName,
        profilePictureUrl = profilePictureUrl,
        imageUrl = imageUrl,
        emotion = emotion
    )

fun PhotoEmotion.toDTO(): PhotoEmotionDTO =
    PhotoEmotionDTO(
        profilAccountId = profilAccountId,
        profilName = profilName,
        profilePictureUrl = profilePictureUrl,
        imageUrl = imageUrl,
        emotion = emotion
    )