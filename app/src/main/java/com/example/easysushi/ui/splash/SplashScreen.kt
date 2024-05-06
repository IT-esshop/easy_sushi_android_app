package com.example.easysushi.ui.splash

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.easysushi.EasySushiScreen
import com.example.easysushi.R
import com.example.easysushi.ui.LocalRootNavController
import com.example.easysushi.ui.theme.EasySushiColors

private val SPLASH_ICON_SIZE = 245.dp

@Composable
fun SplashScreen(
    viewModel: SplashViewModel = hiltViewModel()
) {
    val showSplash = viewModel.showSplash

    val navController = LocalRootNavController.current

    if (!showSplash.value) {
        LaunchedEffect(key1 = showSplash.value) {
            Log.d("Splash", "${showSplash.value}")
            navController.navigate(EasySushiScreen.Main.route)
        }
    } else {
        Surface(color = EasySushiColors.Green) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    modifier = Modifier
                        .size(SPLASH_ICON_SIZE),
                    contentDescription = "Splash screen",
                )
            }
        }
    }
}