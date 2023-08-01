package com.example.easysushi.ui.splash

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val SPLASH_SCREEN_DEFAULT_DELAY = 3000L

@HiltViewModel
class SplashViewModel @Inject constructor(): ViewModel() {

    val showSplash = mutableStateOf(true)

    init {
        Log.d("Splash", "showSplash is ${showSplash.value}")
        stopSplash()
    }

    private fun stopSplash() {
        viewModelScope.launch {
//            delay(SPLASH_SCREEN_DEFAULT_DELAY) // TODO Позже прикрутить загрузку данных во время сплеша
            showSplash.value = false
        }
    }
}