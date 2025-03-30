package com.projtech.domain.repository

import com.projtech.domain.model.Contact
import kotlinx.coroutines.flow.Flow

interface ContactRepository {
    fun fetchContacts(): Flow<List<Contact>>
}