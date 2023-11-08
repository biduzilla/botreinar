package com.ricky.botreinar.presentation.home.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ricky.botreinar.navigation.BottomScreens

@Composable
fun BottomBar(
    navController: NavController,
    onChangeTela: (String) -> Unit
) {
    val items = listOf(
        BottomScreens.TreinoScreen,
        BottomScreens.CardioScreen,
        BottomScreens.HistoricoScreen,
        BottomScreens.ConfigScreen,
    )

    NavigationBar {
        val navBack by navController.currentBackStackEntryAsState()
        val currentRoute = navBack?.destination?.route

        items.forEach { item ->
            NavigationBarItem(selected = currentRoute?.split("/")
                ?.get(0) == item.route,
                label = { Text(text = item.route) },
                alwaysShowLabel = true,
                icon = {
                    Icon(
                        imageVector = if (currentRoute?.split("/")
                                ?.get(0) == item.route
                        ) item.selectedIcon else item.unselectedIcon,
                        contentDescription = item.route
                    )
                },
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                })
        }
    }
}