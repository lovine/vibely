package com.projtech.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.projtech.domain.model.Contact
import com.projtech.domain.model.Photo
import com.projtech.domain.model.UserHistoryPhotoEmotion
import com.projtech.domain.usecase.FetchContactsWithPhotosUseCase
import com.projtech.domain.usecase.FetchVibelyDayPhotoUseCase
import com.projtech.domain.usecase.GetEmotionHistoryUseCase
import com.projtech.domain.usecase.GetEmotionOfDayUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getEmotionOfDayUseCase: GetEmotionOfDayUseCase,
    private val getUserEmotionHistoryUseCase: GetEmotionHistoryUseCase,
    private val getVibelyDayPhotoUseCase: FetchVibelyDayPhotoUseCase,
    private val getContactUseCase: FetchContactsWithPhotosUseCase
) : ViewModel() {

    private val _emotion = MutableStateFlow("")
    val emotion: StateFlow<String> = _emotion.asStateFlow()
    private val _vibelyDayPhoto = MutableStateFlow<Photo?>(null)
    val vibelyDayPhoto: StateFlow<Photo?> = _vibelyDayPhoto.asStateFlow()
    private val _contacts = MutableStateFlow<List<Contact>>(emptyList())
    val contacts: StateFlow<List<Contact>> = _contacts.asStateFlow()
    private val _selectedContact = MutableStateFlow<Contact?>(null)
    val selectedContact: StateFlow<Contact?> = _selectedContact.asStateFlow()

    private val _userHistoryEmotion = MutableStateFlow<List<UserHistoryPhotoEmotion>>(emptyList())
    val userHistoryEmotion: StateFlow<List<UserHistoryPhotoEmotion>> = _userHistoryEmotion.asStateFlow()

    init {
        loadEmotionOfTheDay()
        getContact()
        loadUserEmotionHistory()
    }

    fun markPhotoAsSeen(contactId: String) {
        val updatedList = _contacts.value.map {
            if (it.id == contactId) it.copy(hasSeenPhoto = true) else it
        }
        _contacts.value = updatedList
    }

    private fun loadUserEmotionHistory() {
        viewModelScope.launch {
            getUserEmotionHistoryUseCase().collectLatest {
                _userHistoryEmotion.emit(it)
            }
        }
    }

    private fun loadEmotionOfTheDay() {
        viewModelScope.launch {
            getEmotionOfDayUseCase().collectLatest {
                _emotion.emit(it)
            }
        }
    }

      fun getVibelyDayPhoto() {
        viewModelScope.launch {
            getVibelyDayPhotoUseCase().collectLatest {
                _vibelyDayPhoto.emit(it)
            }
        }
    }

    fun getContact() {
        viewModelScope.launch {
            getContactUseCase().collect {
                _contacts.emit(it)
            }
        }
    }

    fun selectContact(contact: Contact) {
        _selectedContact.value = contact
    }

    fun clearSelectedContact() {
        _selectedContact.value = null
    }
}
