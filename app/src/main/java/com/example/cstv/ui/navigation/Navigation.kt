package com.example.cstv.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.cstv.ui.screen.main.MainScreen
import com.example.cstv.ui.screen.matchDetail.MatchDetailScreen
import com.example.cstv.ui.screen.splash.SplashScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationScreens.SplashScreen.name) {
        composable(NavigationScreens.SplashScreen.name) {
            SplashScreen(navController)
        }

        composable(NavigationScreens.MainScreen.name) {
            MainScreen(navController)
        }

        composable(
            route = NavigationScreens.MatchDetailScreen.name + "/{matchId}/{title}",
            arguments = listOf(navArgument(name = "matchId") {
                type = NavType.LongType
                nullable = false
            }, navArgument(name = "title") {
                type = NavType.StringType
                nullable = false
            }
            )
        ) { entry ->
            MatchDetailScreen(
                navController,
                entry.arguments?.getLong("matchId") ?: 0L,
                entry.arguments?.getString("title").orEmpty()
            )
        }
    }
}