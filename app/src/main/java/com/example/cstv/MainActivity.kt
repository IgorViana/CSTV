package com.example.cstv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cstv.ui.navigation.Navigation
import com.example.cstv.ui.navigation.NavigationScreens
import com.example.cstv.ui.screen.main.MainScreen
import com.example.cstv.ui.screen.matchDetail.MatchDetailScreen
import com.example.cstv.ui.screen.splash.SplashScreen
import com.example.cstv.ui.theme.CSTVTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CSTVTheme {
                val navController = rememberNavController()
                Navigation(navController = navController)
            }
        }
    }
}