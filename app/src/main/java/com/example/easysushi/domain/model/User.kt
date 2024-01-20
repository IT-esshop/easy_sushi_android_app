package com.example.easysushi.domain.model

data class User(
    val userId: Long,
    val name: String,
    val surname: String,
    val birthDate: String,
    val phoneNumber: String,
    val discountPercentage: Int,
    val ordersQuantity: Int
)
