package com.example.easysushi.domain.repository

import com.example.easysushi.domain.model.Ware
import kotlinx.coroutines.flow.Flow

interface WaresRepository {
    fun getAllWares(): List<Ware>
    fun getWareById(wareId: Long): Ware?
}
