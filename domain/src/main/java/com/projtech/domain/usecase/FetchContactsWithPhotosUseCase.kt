package com.projtech.domain.usecase

import com.projtech.domain.model.Contact
import com.projtech.domain.repository.ContactRepository
import kotlinx.coroutines.flow.Flow

class FetchContactsWithPhotosUseCase(private val contactRepository: ContactRepository) {

    suspend operator fun invoke(): Flow<List<Contact>> {
        return contactRepository.fetchContacts()
    }
}