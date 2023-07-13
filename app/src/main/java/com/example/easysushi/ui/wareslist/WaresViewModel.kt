package com.example.easysushi.ui.wareslist

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.easysushi.domain.model.Ware
import com.example.easysushi.domain.repository.WaresRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WaresViewModel @Inject constructor(
    private val waresRepository: WaresRepository
): ViewModel() {

    val wares = mutableStateOf<List<Ware>>(emptyList())

    init {
        waresRepository.getAllWares()
    }
}