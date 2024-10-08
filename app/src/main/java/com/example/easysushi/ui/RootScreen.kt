package com.example.easysushi.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.easysushi.EasySushiScreen
import com.example.easysushi.ui.splash.SplashScreen

var LocalRootNavController: ProvidableCompositionLocal<NavHostController> =
    compositionLocalOf { error("Activity is not created") }

@Composable
fun RootScreen() {

    CompositionLocalProvider(LocalRootNavController provides rememberNavController()) {
        val navController = LocalRootNavController.current
        NavHost(
            navController = navController,
            startDestination = EasySushiScreen.Splash.route
        ) {
            composable(EasySushiScreen.Splash.route) { SplashScreen() }
            composable(EasySushiScreen.Main.route) { MainScreen() }
        }
    }
}
