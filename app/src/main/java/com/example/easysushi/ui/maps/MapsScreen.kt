package com.example.easysushi.ui.maps

import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidViewBinding
import com.example.easysushi.databinding.FragmentMapsBinding
import com.yandex.mapkit.Animation
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition

@Composable
fun MapsScreen() {
    AndroidViewBinding(FragmentMapsBinding::inflate) {
        val mapView = this.mapview
        mapView.map.move(
            CameraPosition(
                Point(59.928337, 30.321201), 11.0f, 0.0f, 0.0f),
            Animation(Animation.Type.SMOOTH, 0F),
            null
        )
    }
}
