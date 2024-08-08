package com.avrians.tilikbrebes.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Favorite : Screen("favorite")
    object Profile : Screen("profile")
    object DetailWisata : Screen("home/{wisataId}") {
        fun createRoute(wisataId: Int) = "home/$wisataId"
    }
}