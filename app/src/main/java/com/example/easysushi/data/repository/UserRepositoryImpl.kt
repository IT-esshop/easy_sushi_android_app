package com.example.easysushi.data.repository

import com.example.easysushi.domain.model.User
import com.example.easysushi.domain.model.UserPromotion
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
            ordersQuantity = 12,
            cashbackPoints = 10,
            userPromotions = listOf(UserPromotion.stubUserPromotion),
            avatarUrl = "https://cdn.dribbble.com/users/310943/avatars/normal/63403a089cd09d40cd08f3906bc50ff7.png?1648702627"
        )
    }
}
