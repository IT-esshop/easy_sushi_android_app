package com.example.easysushi.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.easysushi.EasySushiScreen
import com.example.easysushi.R
import com.example.easysushi.ui.base.BottomNavigationBar
import com.example.easysushi.ui.base.NavigationItemData
import com.example.easysushi.ui.cart.CartScreen
import com.example.easysushi.ui.maps.MapsScreen
import com.example.easysushi.ui.wareslist.WaresScreen
import com.example.easysushi.ui.userprofile.UserProfileScreen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(
    viewModel: MainViewModel = hiltViewModel()
) {
    val localNavController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = Color.Transparent,
        bottomBar = {
            BottomNavigationBar(
                navController = localNavController,
                tabs = listOf(
                    NavigationItemData(
                        icon = R.drawable.icon_sushi,
                        route = EasySushiScreen.WaresList.route,
                        title = stringResource(id = R.string.wares_list_screen_title)
                    ),
                    NavigationItemData(
                        icon = R.drawable.icon_cart,
                        route = EasySushiScreen.Cart.route,
                        title = stringResource(id = R.string.cart_screen_title)
                    ),
                    NavigationItemData(
                        icon = R.drawable.icon_user_profile,
                        route = EasySushiScreen.UserProfile.route,
                        title = stringResource(id = R.string.user_profile_screen_title)
                    ),
                    NavigationItemData(
                        icon = R.drawable.icon_maps,
                        route = EasySushiScreen.Maps.route,
                        title = stringResource(id = R.string.maps_screen_title)
                    ),
                )
            )
        }
    ) {
        NavHost(
            navController = localNavController,
            startDestination = EasySushiScreen.WaresList.route,
        ) {
            composable(EasySushiScreen.WaresList.route) {
                WaresScreen()
            }
            composable(EasySushiScreen.Cart.route) {
                CartScreen()
            }
            composable(EasySushiScreen.UserProfile.route) {
                UserProfileScreen()
            }
            composable(EasySushiScreen.Maps.route) {
                MapsScreen()
            }
        }
    }
}
