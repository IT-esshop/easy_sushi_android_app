package com.example.easysushi.ui.base

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.easysushi.EMPTY_STRING
import com.example.easysushi.R
import com.example.easysushi.ui.theme.EasySushiColors

val BOTTOM_MENU_TEXT_SIZE = 12.sp

/**
 * Функция для создания bottom navigation
 * @param navController [NavController], в котором вызываются навигационные команды
 * @param tabs listOf [NavigationItemData] представляющий вкладки
 * @param onNavigated callback, вызываемый когда срабатывает onClick по конкретной [BottomNavigationItem].
 * Возвращает [Boolean] который показывает, надо ли проводить навигацию (т.е, можно остановить навигацию, если
 * вернуть false). По умолчанию { true }
 * @param screensToHide listOf [String], в котором перечислены экраны на которых необходимо прятать

 * BottomNavigationBar
 */
@Composable
fun BottomNavigationBar(
    navController: NavController,
    tabs: List<NavigationItemData>,
    backgroundColor: Color = EasySushiColors.Green,
    onNavigated: (NavigationItemData) -> Boolean = { true },
    screensToHide: List<String> = listOf()
) {

    val hideBottomBar = rememberSaveable { mutableStateOf(false) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    hideBottomBar.value = navBackStackEntry?.destination?.route in screensToHide

    if (hideBottomBar.value) return

    BottomNavigation(
        backgroundColor = backgroundColor
    ) {
        val currentDestination = navBackStackEntry?.destination
        tabs.forEach { itemData ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(id = itemData.icon),
                        contentDescription = itemData.contentDescription
                    )
                },
                label = {
                    Text(
                        text = itemData.title ?: EMPTY_STRING,
                        fontSize = BOTTOM_MENU_TEXT_SIZE
                    )
                },
                selected = currentDestination?.hierarchy?.any { it.route == itemData.route } == true,
                onClick = {
                    if (onNavigated(itemData)) {
                        navController.navigate(itemData.route) {
                            // Pop up to the start destination of the graph to
                            // avoid building up a large stack of destinations
                            // on the back stack as users select items
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            // Avoid multiple copies of the same destination when
                            // reselecting the same item
                            launchSingleTop = true
                            // Restore state when reselecting a previously selected item
                            restoreState = true
                        }
                    } else {
                        Log.w("bottomBar","onNavigated($itemData) return false, will not navigate")
                    }
                }
            )
        }
    }
}

class NavigationItemData(
    @DrawableRes val icon: Int,
    val route: String,
    val title: String,
    val contentDescription: String? = null
) {
    constructor(icon: Int, screen: Screen, title: String, contentDescription: String? = null) : this(
        icon,
        screen.route,
        title,
        contentDescription
    )
}

@Composable
@Preview
fun BottomNavigationBarPreview() {
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
                tabs = listOf(
                    NavigationItemData(R.drawable.icon_sushi, Screen("1"), "1"),
                    NavigationItemData(R.drawable.icon_cart, Screen("2"), "2"),
                    NavigationItemData(R.drawable.icon_user_profile, Screen("3"), "3"),
                ),
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "1",
            Modifier.padding(innerPadding)
        ) {
            composable("1") {
                StubScreen("Экран 1")
            }
            composable("2") {
                StubScreen("Экран 2")
            }
            composable("3") {
                StubScreen("Экран 3")
            }
        }
    }
}
