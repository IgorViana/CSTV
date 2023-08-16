package com.example.cstv.ui.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cstv.R
import com.example.cstv.ui.navigation.NavigationScreens
import com.example.cstv.ui.theme.CSTVTheme
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavController) {

    LaunchedEffect(key1 = null, block = {
        delay(2000)
        navController.popBackStack()
        navController.navigate(NavigationScreens.MainScreen.name)
    })

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF161621)),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .width(113.dp)
                .height(113.dp),
            painter = painterResource(id = R.drawable.fuze_logo),
            contentDescription = "Fuze logo",
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
