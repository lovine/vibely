package com.projtech.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.projtech.domain.model.Contact
import com.projtech.domain.usecase.FetchContactsWithPhotosUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ContactsViewModel(
    private val getContactsWithPhotosUseCase: FetchContactsWithPhotosUseCase
) : ViewModel() {

    private val _contacts = MutableStateFlow<List<Contact>>(emptyList())
    val contacts: StateFlow<List<Contact>> = _contacts

    init {
        viewModelScope.launch {
//            getContactsWithPhotosUseCase().collect {
//                _contacts.value = it
//            }
        }
    }
}