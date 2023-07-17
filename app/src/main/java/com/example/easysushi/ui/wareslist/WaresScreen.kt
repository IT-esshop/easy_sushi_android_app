package com.example.easysushi.ui.wareslist

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.easysushi.domain.usecases.GetAllWaresUseCase
import com.example.easysushi.ui.MainViewModel
import com.example.easysushi.ui.base.StubScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun WaresScreen(
    viewModel: WaresViewModel = hiltViewModel()
) {
    StubScreen(text = "Список товаров: В Разработке")
}

@Preview
@Composable
fun WaresScreenPreview() {
    WaresScreen()
}