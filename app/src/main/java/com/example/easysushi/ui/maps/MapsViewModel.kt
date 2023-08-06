package com.example.easysushi.ui.maps

import androidx.lifecycle.ViewModel
import com.yandex.mapkit.Animation
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MapsViewModel @Inject constructor(): ViewModel() {

    fun scaleToStartPoint(mapView: MapView) {
        mapView.map.move(
            CameraPosition(
                Point(59.928337, 30.321201), 11.0f, 0.0f, 0.0f),
            Animation(Animation.Type.SMOOTH, 0F),
            null
        )
    }
}