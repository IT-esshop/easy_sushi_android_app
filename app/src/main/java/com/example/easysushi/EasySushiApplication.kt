package com.example.easysushi

import android.app.Application
import android.content.Context
import androidx.startup.Initializer
import com.example.easysushi.core.ResResolver
import com.example.easysushi.di.DomainModule
import com.yandex.mapkit.MapKitFactory
import dagger.Module
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class EasySushiApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        ResResolver.setContext(applicationContext)
        MapKitFactory.setApiKey(YANDEX_MAPKIT_API_KEY)
    }
}
