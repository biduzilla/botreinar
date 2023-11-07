package com.ricky.botreinar.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ricky.botreinar.presentation.treinos.TreinoViewModel
import com.ricky.botreinar.presentation.treinos.TreinosScreens

@Composable
fun BottomNavigation(
    navHostControler: NavHostController,
    navControler: NavController
) {
    NavHost(
        navController = navHostControler,
        startDestination = BottomScreens.TreinoScreen.route,
    ) {
        composable(BottomScreens.TreinoScreen.route) {
            val viewModel = hiltViewModel<TreinoViewModel>()
            val state by viewModel.state.collectAsState()

            TreinosScreens(
                navController = navControler,
                state = state,
                onEvent = viewModel::onEvent
            )
        }
    }
}