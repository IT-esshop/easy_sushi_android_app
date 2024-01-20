package com.example.easysushi.domain.usecases

import com.example.easysushi.UNKNOWN_ERROR
import com.example.easysushi.core.DataState
import com.example.easysushi.core.UiComponent
import com.example.easysushi.domain.model.Ware
import com.example.easysushi.domain.repository.WaresRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllWaresUseCase @Inject constructor(
    private val repository: WaresRepository
) {
    fun execute(): Flow<DataState<List<Ware>>> {
        return flow {
            emit(DataState.Loading(true))
            try {
                val wares = repository.getAllWares()
                emit(DataState.Success(wares))
            } catch (e: Exception) {
                e.printStackTrace()
                emit(DataState.Error(UiComponent.Toast(e.message ?: UNKNOWN_ERROR)))
            } finally {
                emit(DataState.Loading(false))
            }
        }
    }
}
