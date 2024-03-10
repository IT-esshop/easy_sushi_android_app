package com.example.easysushi.ui.maps

import androidx.lifecycle.ViewModel
import com.example.easysushi.R
import com.example.easysushi.core.ResResolver.getImageProviderWithDrawableRes
import com.example.easysushi.domain.model.restaurantPoints
import com.yandex.mapkit.Animation
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.map.MapObjectCollection
import com.yandex.mapkit.map.PlacemarkMapObject
import com.yandex.mapkit.mapview.MapView
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MapsViewModel @Inject constructor() : ViewModel() {

    private val startLocation = Point(59.893184, 30.381547)
    private val startZoomValue = 11.0f

    fun moveToStartLocation(mapView: MapView) {
        mapView.map.move(
            CameraPosition(
                startLocation, startZoomValue, 0.0f, 0.0f
            ),
            Animation(Animation.Type.SMOOTH, 0F),
            null
        )
    }

    fun getAvailableRestaurants(mapObjectCollection: MapObjectCollection): List<PlacemarkMapObject> =
        restaurantPoints.map { point ->
            mapObjectCollection.addPlacemark(
                point, getImageProviderWithDrawableRes(R.drawable.map_pointer_easysushi)
            )
        }
}
