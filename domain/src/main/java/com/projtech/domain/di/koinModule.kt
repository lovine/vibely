package com.projtech.domain.di

import com.projtech.domain.usecase.FetchContactsWithPhotosUseCase
import com.projtech.domain.usecase.FetchVibelyDayPhotoUseCase
import com.projtech.domain.usecase.GetEmotionHistoryUseCase
import com.projtech.domain.usecase.GetEmotionOfDayUseCase
import com.projtech.domain.usecase.GetExplorePhotosUseCase
import com.projtech.domain.usecase.SavePhotoUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetEmotionOfDayUseCase(get()) }
    factory { FetchVibelyDayPhotoUseCase(get()) }
    factory { SavePhotoUseCase(get()) }
    factory { GetExplorePhotosUseCase(get()) }
    factory { FetchContactsWithPhotosUseCase(get()) }
    factory { GetEmotionHistoryUseCase(get()) }
}