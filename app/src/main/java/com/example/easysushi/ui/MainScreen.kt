package com.example.easysushi.ui

import android.annotation.SuppressLint
import android.graphics.Paint.Align
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.easysushi.EasySushiScreen
import com.example.easysushi.R
import com.example.easysushi.core.components.AddToCartButton
import com.example.easysushi.ui.base.BottomNavigationBar
import com.example.easysushi.ui.base.NavigationItemData
import com.example.easysushi.ui.cart.CartScreen
import com.example.easysushi.ui.maps.MapsScreen
import com.example.easysushi.ui.theme.EasySushiColors
import com.example.easysushi.ui.wareslist.WaresScreen
import com.example.easysushi.ui.userprofile.UserProfileScreen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(
    viewModel: MainViewModel = hiltViewModel()
) {
    val waresInCart by viewModel.waresInCart.collectAsState()
    val localNavController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                elevation = 4.dp,
                backgroundColor = EasySushiColors.Green,
                modifier = Modifier.fillMaxWidth().height(70.dp)
            ) {
                MainTopAppBar(
                    waresInCart = waresInCart,
                    onAddToCartClicked = viewModel::onAddToCartClicked
                )
            }
        },
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

@Composable
fun MainTopAppBar(
    waresInCart: Int,
    onAddToCartClicked: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Transparent),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "title logo",
                modifier = Modifier.size(width = 130.dp, height = 30.dp)
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Transparent)
                .padding(end = 10.dp),
            contentAlignment = Alignment.CenterEnd
        ) {
            AddToCartButton(
                waresInCart = 10,
                onAddToCardClicked = onAddToCartClicked,
                elementSize = 50.dp
            )
        }
    }

}

@Preview
@Composable
fun MainTopAppBarPreview() {
    MainTopAppBar(waresInCart = 1) {}
}
