package com.example.easysushi.ui.cart

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(): ViewModel() {

    init {
        Log.d("CartViewModel", "init CartViewModel")
    }
}
