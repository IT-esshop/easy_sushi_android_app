package com.example.easysushi.ui.maps

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidViewBinding
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.easysushi.databinding.FragmentMapsBinding
import com.yandex.mapkit.Animation
import com.yandex.mapkit.geometry.Circle
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView

@Composable
fun MapsScreen(
    viewModel: MapsViewModel = hiltViewModel()
) {
    MapsScreenContent(
        scaleToStartPoint = viewModel::scaleToStartPoint
    )
}

@Composable
fun MapsScreenContent(
    scaleToStartPoint: (MapView) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        AndroidViewBinding(FragmentMapsBinding::inflate) {
            val mapView = this.mapview
            scaleToStartPoint(mapView)
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Circle(Point(59.928337, 30.321201), 100f)
        }
    }
}

@Preview
@Composable
fun MapsScreenPreview() {
    MapsScreenContent(
        scaleToStartPoint = {},
    )
}
