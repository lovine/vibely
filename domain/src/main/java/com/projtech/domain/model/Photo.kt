package com.projtech.domain.model

data class Photo(
    val id: String,
    val path: String,
    val emotion: String,
    val timestamp: Long
)