package com.ricky.botreinar.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.RunCircle
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.FitnessCenter
import androidx.compose.material.icons.outlined.RunCircle
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomScreens(
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
) {
    object TreinoScreen : BottomScreens(
        route = "treino",
        selectedIcon = Icons.Filled.FitnessCenter,
        unselectedIcon = Icons.Outlined.FitnessCenter
    )

    object CardioScreen : BottomScreens(route = "cardio",
        selectedIcon = Icons.Filled.RunCircle,
        unselectedIcon = Icons.Outlined.RunCircle)
    object ConfigScreen : BottomScreens(route = "config",
        selectedIcon = Icons.Filled.Settings,
        unselectedIcon = Icons.Outlined.Settings)

}
