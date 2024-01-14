package com.example.easysushi

import com.example.easysushi.ui.base.Screen

sealed class EasySushiScreen(override val route: String): Screen(route) {
    object Splash : EasySushiScreen("splash")
    object Main : EasySushiScreen("main")
    object WaresList : EasySushiScreen("wares_list")
    object Cart : EasySushiScreen("cart")
    object UserProfile : EasySushiScreen("user_profile")
    object Maps : EasySushiScreen("maps")
}
