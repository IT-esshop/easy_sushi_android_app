package com.example.easysushi.domain.model

data class Ware(
    val id: Long,
    val name: String,
    val wareCategory: WareCategory,
    val price: Int,
    val composition: String,
    val weight: Int,
    val kcal: Int,
    val protein: Int,
    val fat: Int,
    val carbohydrates: Int,
    val imageUrl: String,
    val quantityInCart: Int = 0 // Todo Создать БД для корзины в будущем
)
