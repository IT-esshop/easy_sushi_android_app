package com.example.easysushi.domain.model

import com.example.easysushi.domain.model.Restaurants.BABUSHKINA
import com.example.easysushi.domain.model.Restaurants.MOSKOVSKIY
import com.example.easysushi.domain.model.Restaurants.SADOVAYA
import com.example.easysushi.domain.model.Restaurants.ZANEVSKIY
import com.yandex.mapkit.geometry.Point

enum class Restaurants(val title: String, val point: Point) {
    SADOVAYA(title = "Садовая 33", point = Point(59.920891, 30.339083)),
    MOSKOVSKIY(title = "Московский 167", point = Point(59.864598, 30.319634)),
    BABUSHKINA(title = "Бабушкина 42", point = Point(59.882968, 30.432750)),
    ZANEVSKIY(title = "Заневский 23", point = Point(59.923303, 30.437563))
}

val restaurantPoints = setOf(
    SADOVAYA.point,
    MOSKOVSKIY.point,
    BABUSHKINA.point,
    ZANEVSKIY.point
)
