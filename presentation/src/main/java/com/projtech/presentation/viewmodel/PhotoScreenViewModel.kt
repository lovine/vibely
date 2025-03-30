package com.projtech.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.projtech.domain.usecase.GetEmotionOfDayUseCase
import com.projtech.domain.usecase.SavePhotoUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class PhotoScreenViewModel(
    private val getEmotionOfDayUseCase: GetEmotionOfDayUseCase,
    private val savePhotoUseCase: SavePhotoUseCase
) : ViewModel() {

    private val _emotion = MutableStateFlow("")
    val emotion: StateFlow<String> = _emotion

    init {
        viewModelScope.launch {
            getEmotionOfDayUseCase().collectLatest {
                _emotion.emit(it)
            }
        }
    }

    fun savePhoto(path: String, emotion: String) {
        viewModelScope.launch {
            savePhotoUseCase(path, emotion)
        }
    }
}
