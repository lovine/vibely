package com.projtech.data.mapper

import com.projtech.data.model.PhotoDTO
import com.projtech.domain.model.Photo

fun PhotoDTO.toDomain(): Photo =
    Photo(
        id = id,
        path = path,
        emotion = emotion,
        timestamp = timestamp
    )

fun Photo.toDTO(): PhotoDTO =
    PhotoDTO(
        id = id,
        path = path,
        emotion = emotion,
        timestamp = timestamp
    )
