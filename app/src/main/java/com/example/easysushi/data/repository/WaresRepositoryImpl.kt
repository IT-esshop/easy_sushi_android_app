package com.example.easysushi.data.repository

import com.example.easysushi.domain.model.Ware
import com.example.easysushi.domain.model.WareCategory
import com.example.easysushi.domain.repository.WaresRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import javax.inject.Inject

class WaresRepositoryImpl @Inject constructor() : WaresRepository {

    override fun getAllWares(): List<Ware> {
        return listOf(
            Ware(
                id = 0,
                name = "Филадельфия",
                wareCategory = WareCategory.ROLLS,
                price = 169,
                composition = "Лосось, сливочный сыр, огурец",
                weight = 185,
                kcal = 238,
                protein = 7,
                fat = 10,
                carbohydrates = 30,
                imageUrl = "https://www.sushieasy.ru/assets/images/cache/docs/24417/roll_filadelfiya_sfs.png/1655973419/320.png"
            ),
        )
    }
}
