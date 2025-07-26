package com.kurumani.com

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kurumani.com.home.ConversionScreen
import com.kurumani.com.home.HomeScreen
import com.kurumani.com.home.Platform

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Conversion : Screen("conversion/{platform}") {
        fun createRoute(platform: Platform): String = "conversion/${platform.name}"
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }

        composable(
            route = Screen.Conversion.route,
            arguments = listOf(navArgument("platform") { type = NavType.StringType })
        ) { backStackEntry ->
            val platformName = backStackEntry.arguments?.getString("platform") ?: "Youtube"
            val platform = Platform.valueOf(platformName)

            ConversionScreen(platform = platform)
        }

    }
}
