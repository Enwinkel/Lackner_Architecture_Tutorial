package com.stasst.cleanarchproj.presentation

sealed class NavRoute(val route: String) {
    data object CoinListScreen: NavRoute("coin_list_screen")
    data object CoinDetails: NavRoute("coin_details_screen")
}