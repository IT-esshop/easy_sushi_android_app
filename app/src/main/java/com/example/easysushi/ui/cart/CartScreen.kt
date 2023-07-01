package com.example.easysushi.ui.cart

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import com.example.easysushi.ui.base.StubScreen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CartScreen(
    viewModel: CartViewModel = hiltViewModel()
) {
    StubScreen(text = "Корзина: В Разработке")
}
