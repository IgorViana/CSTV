package com.example.cstv.ui.screen.main

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cstv.ui.components.LoadingComponent
import com.example.cstv.ui.components.MatchItem
import com.example.cstv.ui.navigation.NavigationScreens
import com.example.cstv.ui.theme.CSTVTheme
import com.google.gson.Gson

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainScreen(navController: NavController) {

    val viewModel: MainViewModel = hiltViewModel()

    val state = viewModel.state.collectAsState()

    val pullState = rememberPullRefreshState(
        refreshing = state.value.isLoading,
        onRefresh = viewModel::getMatches
    )

    Column(modifier = Modifier.background(color = Color(0xFF161621))) {

        Text(text = "Partidas", modifier = Modifier.padding(24.dp))

        if (state.value.isLoading) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator(modifier = Modifier.size(100.dp))
            }
        }
        state.value.matches?.let { matchesList ->
            LazyColumn(Modifier.pullRefresh(pullState)) {
                items(matchesList) { match ->
                    MatchItem(item = match, onMatchClick = { matchId ->
                        navController.navigate(NavigationScreens.MatchDetailScreen.name + "/$matchId")
                    })
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    CSTVTheme {
        MainScreen(rememberNavController())
    }
}