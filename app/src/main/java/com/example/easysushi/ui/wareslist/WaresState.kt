package com.example.easysushi.ui.wareslist

import com.example.easysushi.domain.model.Ware

data class WaresState(
    val progressBar: Boolean = false,
    val wares: List<Ware> = emptyList(),
    val error: String? = null
)
