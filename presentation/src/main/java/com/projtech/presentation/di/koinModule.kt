package com.projtech.presentation.di

import com.projtech.presentation.viewmodel.ContactsViewModel
import com.projtech.presentation.viewmodel.ExploreViewModel
import com.projtech.presentation.viewmodel.HomeViewModel
import com.projtech.presentation.viewmodel.PhotoScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { HomeViewModel(get(), get(), get(), get()) }
    viewModel { PhotoScreenViewModel(get(), get()) }
    viewModel { ContactsViewModel(get()) }
    viewModel { ExploreViewModel(get()) }
}