package com.example.easysushi

sealed class EasySushiScreen(val route: String) {
    object Splash : EasySushiScreen("splash")
    object Main : EasySushiScreen("main")
    object WaresList : EasySushiScreen("wares_list")
    object Cart : EasySushiScreen("cart")
    object UserProfile : EasySushiScreen("user_profile")
}
