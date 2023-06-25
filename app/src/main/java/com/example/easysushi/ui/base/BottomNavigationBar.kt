package com.example.easysushi.ui.base

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.easysushi.R

val BOTTOM_MENU_TEXT_SIZE = 12.sp

@Composable
fun BottomNavigationBar() {
    val items = setOf(
        NavigationItem.WareList,
        NavigationItem.Cart,
        NavigationItem.UserProfile
    )
    BottomNavigation(
        backgroundColor = Color.Green,
        contentColor = Color.White
    ) {
        items.forEach { bottomItem ->
            BottomNavigationItem(
                icon = {
                    Icon(painter = painterResource(id = bottomItem.icon), contentDescription = bottomItem.title)
                },
                label = {
                    Text(text = bottomItem.title, fontSize = BOTTOM_MENU_TEXT_SIZE)
                },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.7f),
                selected = false,
                onClick = { TODO() }
            )
        }
    }
}

@Preview
@Composable
fun BottomBarPreview() {
    BottomNavigationBar()
}

sealed class NavigationItem(val route: String, val icon: Int, val title: String) {
    object WareList : NavigationItem(
        route = "ware_list",
        icon = R.drawable.icon_sushi,
        title = "Товары" // TODO
    )

    object Cart : NavigationItem(
        route = "cart",
        icon = R.drawable.icon_cart,
        title = "Корзина" // TODO
    )

    object UserProfile : NavigationItem(
        route = "user_profile",
        icon = R.drawable.icon_user_profile,
        title = "Профиль" // TODO
    )
}
