package com.example.easysushi.ui.wareslist

import androidx.lifecycle.viewModelScope
import com.example.easysushi.core.BaseViewModel
import com.example.easysushi.core.LoaderState
import com.example.easysushi.domain.model.Ware
import com.example.easysushi.domain.repository.WaresRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WaresViewModel @Inject constructor(
    private val waresRepository: WaresRepository,
) : BaseViewModel() {

    private val _waresList = MutableStateFlow(emptyList<Ware>())
    val waresList: StateFlow<List<Ware>>
        get() = _waresList

    init {
        viewModelScope.launch {
            loaderState.value = LoaderState.WARES_LOADING
            delay(3000)
            _waresList.value = getWaresList()
            loaderState.value = LoaderState.DISABLE
        }
    }

    private fun getWaresList(): List<Ware> {
        return waresRepository.getAllWares()
    }

    fun onAddToCartClick(wareId: Long) {
        waresRepository.getWareById(wareId)?.let { ware ->
            if (ware.quantityInCart > 0) {

            }
        }
    }
}
