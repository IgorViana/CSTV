package com.example.cstv.ui.screen.splash

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cstv.ui.theme.CSTVTheme

@Composable
fun SplashScreen(navController: NavController) {
    Text(text = "Splash")
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    CSTVTheme {
        SplashScreen(rememberNavController())
    }
}
