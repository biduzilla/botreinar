package com.ricky.botreinar.navigation

sealed class Screens(val route: String) {
    object SplashScreen : Screens(route = "splash")
    object TreinoDetalheScreen : Screens(route = "treinoDetalhes")
    object HomeScreen : Screens(route = "home")

}
