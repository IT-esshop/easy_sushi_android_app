package com.example.easysushi.ui.wareslist

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.easysushi.domain.model.Ware
import com.example.easysushi.domain.usecases.GetAllWaresUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class WaresViewModel @Inject constructor(
    useCase: GetAllWaresUseCase
) : ViewModel() {

    private val _ware = MutableStateFlow(listOf<Ware>())
    val ware = _ware.asStateFlow()

    init {
        Log.d("WaresViewModel", "Init WaresViewModel")
        _ware.value = useCase.invoke()
    }
}
