package com.example.easysushi.ui.wareslist

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.easysushi.core.UiComponent
import com.example.easysushi.domain.model.Ware
import com.example.easysushi.domain.usecases.GetAllWaresUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class WaresViewModel @Inject constructor(
    private val getAllWares: GetAllWaresUseCase
) : ViewModel(), ContainerHost<WaresState, UiComponent> {

    private val _ware = MutableStateFlow(listOf<Ware>())
    val ware = _ware.asStateFlow()

    override val container: Container<WaresState, UiComponent> = container(WaresState())
}
