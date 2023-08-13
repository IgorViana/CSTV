package com.example.cstv.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.cstv.ui.screen.main.MainScreen
import com.example.cstv.ui.screen.matchDetail.MatchDetailScreen
import com.example.cstv.ui.screen.splash.SplashScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationScreens.MainScreen.name) {
        composable(NavigationScreens.SplashScreen.name) {
            SplashScreen(navController)
        }

        composable(NavigationScreens.MainScreen.name) {
            MainScreen(navController)
        }

        composable(NavigationScreens.MatchDetailScreen.name) {
            MatchDetailScreen(navController)
        }
    }
}