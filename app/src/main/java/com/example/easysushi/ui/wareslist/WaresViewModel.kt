package com.example.easysushi.ui.wareslist

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WaresViewModel @Inject constructor(): ViewModel() {

    init {
        Log.d("WaresViewModel", "Init WaresViewModel")
    }
}