package com.example.easysushi

import android.app.Application
import com.example.easysushi.di.DomainModule
import com.yandex.mapkit.MapKitFactory
import dagger.Module
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class EasySushiApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        MapKitFactory.setApiKey(YANDEX_MAPKIT_API_KEY)
    }
}
