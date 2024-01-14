package com.example.easysushi.ui.wareslist

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.easysushi.ui.MainViewModel
import com.example.easysushi.ui.base.StubScreen

private const val WARE_LIST_COLUMNS_QUANTITY = 2

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun WaresScreen(
    viewModel: WaresViewModel = hiltViewModel()
) {
    val wares by viewModel.wares
    Surface {
        LazyVerticalGrid(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            columns = GridCells.Fixed(WARE_LIST_COLUMNS_QUANTITY)
        ) {
            items(10) {
                wares
            }
        }
    }
}



@Preview
@Composable
fun WaresScreenPreview() {
    WaresScreen()
}
