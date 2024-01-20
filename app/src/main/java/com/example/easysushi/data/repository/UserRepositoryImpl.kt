package com.example.easysushi.data.repository

import com.example.easysushi.domain.model.User
import com.example.easysushi.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(): UserRepository {
    override fun getUserById(userId: Long): User {
        return User(
            userId = 1,
            name = "Маруся",
            surname = "Силади",
            birthDate = "01.01.2001",
            phoneNumber = "+79998887766",
            discountPercentage = 15,
            ordersQuantity = 12
        )
    }
}
