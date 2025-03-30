package com.projtech.data.di


import com.projtech.data.repository.EmotionOfDayRepositoryImpl
import com.projtech.data.repository.mock.MockContactRepositoryImpl
import com.projtech.data.repository.mock.MockPhotoRepositoryImpl
import com.projtech.data.repository.mock.MockUserRepositoryImpl
import com.projtech.domain.repository.ContactRepository
import com.projtech.domain.repository.EmotionOfDayRepository
import com.projtech.domain.repository.PhotoRepository
import com.projtech.domain.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {
    single<EmotionOfDayRepository> { EmotionOfDayRepositoryImpl() }
    single<PhotoRepository> { MockPhotoRepositoryImpl() }
    single<ContactRepository> { MockContactRepositoryImpl() }
    single<UserRepository> { MockUserRepositoryImpl() }
}
