package com.projtech.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.projtech.domain.model.PhotoEmotion
import com.projtech.domain.usecase.GetExplorePhotosUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class ExploreViewModel(
    private val getExplorePhotosUseCase: GetExplorePhotosUseCase
) : ViewModel() {

    private val _explorePhotos = MutableStateFlow<List<PhotoEmotion>>(emptyList())
    val explorePhotos: StateFlow<List<PhotoEmotion>> = _explorePhotos

    init {
        fetchExplorePhotos()
    }

    private fun fetchExplorePhotos() {
        viewModelScope.launch {
            getExplorePhotosUseCase().collectLatest {
                _explorePhotos.emit(it)
            }
        }
    }
}