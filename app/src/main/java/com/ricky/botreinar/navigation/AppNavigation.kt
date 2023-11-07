package com.ricky.botreinar.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.ricky.botreinar.presentation.home.HomeScreen
import com.ricky.botreinar.presentation.splash.SplashScreen
import com.ricky.botreinar.presentation.splash.SplashViewModel
import com.ricky.botreinar.presentation.treino_detalhe.TreinoDetalheScreen
import com.ricky.botreinar.presentation.treino_detalhe.TreinoDetalheViewModel

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppNavigation() {
    val navController = rememberAnimatedNavController()

    AnimatedNavHost(navController = navController, startDestination = Screens.SplashScreen.route) {
        composableSlideHorizontally(Screens.SplashScreen.route) {
            val viewModel = hiltViewModel<SplashViewModel>()
            val state by viewModel.state.collectAsState()

            SplashScreen(state = state, navController = navController)
        }

        composableSlideHorizontally(Screens.HomeScreen.route) {
            HomeScreen(navController = navController)
        }

        composableSlideHorizontally(Screens.TreinoDetalheScreen.route + "/{treinoId}") {
            val viewModel = hiltViewModel<TreinoDetalheViewModel>()
            val state by viewModel.state.collectAsState()

            TreinoDetalheScreen(state = state, onEvent = viewModel::onEvent)
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.composableSlideHorizontally(
    route: String,
    duration: Int = 400, // 1000 - 400
    enterOffset: Int = 700, // 300 - 1000
    exitOffset: Int = -700,
    popEnterOffset: Int = -700,
    popExitOffset: Int = 700,
    screen: @Composable () -> Unit
) {
    composable(
        route = route,
        enterTransition = { slideInHorizontally(tween(duration)) { enterOffset } },
        exitTransition = { slideOutHorizontally(tween(duration)) { exitOffset } },
        popEnterTransition = { slideInHorizontally(tween(duration)) { popEnterOffset } },
        popExitTransition = { slideOutHorizontally(tween(duration)) { popExitOffset } },
        content = { screen() }
    )
}