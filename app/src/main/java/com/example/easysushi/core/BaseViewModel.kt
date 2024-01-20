package com.example.easysushi.core

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow

abstract class BaseViewModel: ViewModel() {

    val eventChannel = Channel<Event>()

    val loaderState = MutableStateFlow(LoaderState.DISABLE)
}
