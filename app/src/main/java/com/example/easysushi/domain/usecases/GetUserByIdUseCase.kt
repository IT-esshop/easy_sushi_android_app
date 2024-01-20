package com.example.easysushi.domain.usecases

import com.example.easysushi.UNKNOWN_ERROR
import com.example.easysushi.core.DataState
import com.example.easysushi.core.UiComponent
import com.example.easysushi.domain.model.User
import com.example.easysushi.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

const val TEST_AUTHORIZED_USER_ID = 1L

class GetUserByIdUseCase @Inject constructor(
    private val repository: UserRepository
) {
    operator fun invoke(): Flow<DataState<User>> {
        return flow {
            emit(DataState.Loading(true))
            try {
                val wares = repository.getUserById(TEST_AUTHORIZED_USER_ID)
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
