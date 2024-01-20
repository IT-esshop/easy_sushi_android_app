package com.example.easysushi.ui.wareslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.easysushi.core.DataState
import com.example.easysushi.core.UiComponent
import com.example.easysushi.domain.usecases.GetAllWaresUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class WaresViewModel @Inject constructor(
    private val getAllWares: GetAllWaresUseCase
) : ViewModel(), ContainerHost<WaresState, UiComponent> {

    override val container: Container<WaresState, UiComponent> = container(WaresState())

    init {
        getWaresList()
    }

    private fun getWaresList() {
        intent {
            getAllWares.execute().onEach { dataState ->
                when (dataState) {
                    is DataState.Loading -> {
                        reduce { state.copy(progressBar = dataState.isLoading) }
                    }

                    is DataState.Error -> {
                        when (dataState.uiComponent) {
                            is UiComponent.Toast -> {
                                postSideEffect(UiComponent.Toast(dataState.uiComponent.text))
                            }
                            else -> {}
                        }
                    }

                    is DataState.Success -> {
                        reduce { state.copy(wares = dataState.data) }
                    }
                }
            }.launchIn(viewModelScope)
        }
    }
}
