package com.example.easysushi.ui.maps

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidViewBinding
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.easysushi.databinding.FragmentMapsBinding
import com.example.easysushi.domain.model.Restaurants
import com.yandex.mapkit.geometry.Circle
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.MapObjectCollection
import com.yandex.mapkit.mapview.MapView

@Composable
fun MapsScreen(
    viewModel: MapsViewModel = hiltViewModel()
) {
    MapsScreenContent(
        scaleToStartPoint = viewModel::moveToStartLocation,
        getAvailableRestaurants = viewModel::getAvailableRestaurants
    )
}

@Composable
fun MapsScreenContent(
    scaleToStartPoint: (MapView) -> Unit,
    getAvailableRestaurants: (MapObjectCollection) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        AndroidViewBinding(FragmentMapsBinding::inflate) {
            val mapView = this.mapview
            val mapObjectCollection = this.mapview.map.mapObjects
            scaleToStartPoint(mapView)
            getAvailableRestaurants(mapObjectCollection)
        }
    }
}

@Preview
@Composable
fun MapsScreenPreview() {
    MapsScreenContent(
        scaleToStartPoint = {},
        getAvailableRestaurants = {}
    )
}
