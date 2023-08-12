package com.example.cstv.ui.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cstv.R
import com.example.cstv.ui.navigation.NavigationScreens
import com.example.cstv.ui.theme.CSTVTheme

@Composable
fun SplashScreen(navController: NavController) {

    val viewModel: SplashViewModel = viewModel()

    val isLoading = viewModel.isLoading.collectAsState()

    if (!isLoading.value) {
        navController.navigate(NavigationScreens.MainScreen.name)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .width(113.dp)
                .height(113.dp),
            painter = painterResource(id = R.drawable.fuze_logo),
            contentDescription = "fuze logo",
            contentScale = ContentScale.FillBounds
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    CSTVTheme {
        SplashScreen(rememberNavController())
    }
}
