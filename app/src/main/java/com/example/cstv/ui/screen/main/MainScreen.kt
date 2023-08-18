package com.example.cstv.ui.screen.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cstv.R
import com.example.cstv.ui.components.LoadingComponent
import com.example.cstv.ui.components.MatchItem
import com.example.cstv.ui.navigation.NavigationScreens
import com.example.cstv.ui.theme.CSTVTheme

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

        Text(
            text = stringResource(R.string.partidas),
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth(),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            style = TextStyle(
                color = Color(0xFFFFFFFF),
            )
        )

        if (state.value.isLoading) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                LoadingComponent(modifier = Modifier.size(100.dp))
            }
        }
        state.value.data?.matches?.let { matchesList ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .pullRefresh(pullState)
            ) {
                LazyColumn {
                    items(matchesList) { match ->
                        MatchItem(item = match, onMatchClick = { matchId, title ->
                            navController.navigate(NavigationScreens.MatchDetailScreen.name + "/$matchId/$title")
                        })
                    }
                }

                PullRefreshIndicator(
                    refreshing = false,
                    state = pullState,
                    modifier = Modifier.align(Alignment.TopCenter)
                )
            }
        }

        if (state.value.error != null) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Erro ao carregar dados")
                Button(onClick = { viewModel.getMatches() }) {
                    Text(text = "Tente novamente")
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