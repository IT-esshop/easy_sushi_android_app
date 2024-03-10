package com.example.easysushi

import android.app.Application
import com.example.easysushi.core.ResResolver
import com.yandex.mapkit.MapKitFactory
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class EasySushiApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        ResResolver.setContext(applicationContext)
        MapKitFactory.setApiKey(YANDEX_MAPKIT_API_KEY)
    }
}
