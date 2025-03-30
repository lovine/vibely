package com.projtech.data.model

data class PhotoDTO(
    val id: String,
    val path: String,
    val emotion: String,
    val timestamp: Long = System.currentTimeMillis()
)