package com.projtech.vibely

import android.app.Application
import com.projtech.data.di.dataModule
import com.projtech.domain.di.domainModule
import com.projtech.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class VibelyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@VibelyApplication)
            modules(
                presentationModule,
                domainModule,
                dataModule
            )
        }
    }
}