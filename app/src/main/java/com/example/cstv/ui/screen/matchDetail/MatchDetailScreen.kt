package com.example.cstv.ui.screen.matchDetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cstv.ui.components.LeftSidePlayerComponent
import com.example.cstv.ui.components.LoadingComponent
import com.example.cstv.ui.components.RightSidePlayerComponent
import com.example.cstv.ui.components.TeamComponent
import com.example.cstv.ui.theme.CSTVTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MatchDetailScreen(navController: NavController, matchId: Long, title: String) {

    val viewModel: MatchDetailViewModel = hiltViewModel()
    val state = viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF161621))
            .verticalScroll(rememberScrollState())
    ) {
        TopAppBar(
            modifier = Modifier.fillMaxWidth(),
            title = {
                Text(
                    text = title,
                    style = TextStyle(
                        fontSize = 18.sp,
                        color = Color(0xFFFFFFFF),
                        textAlign = TextAlign.Center,
                    )
                )

            },
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back button",
                        tint = Color.White
                    )
                }
            }, colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color(0xFF161621)
            )
        )

        if (state.value.isLoading) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                LoadingComponent()
            }
        }

        state.value.detailResponse?.let { detailResponse ->
            val team1 = detailResponse.matchDetailResponse.opponents?.getOrNull(0)?.opponent
            val team2 = detailResponse.matchDetailResponse.opponents?.getOrNull(1)?.opponent

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                TeamComponent(
                    model = team1, modifier = Modifier
                        .weight(2f)
                        .fillMaxWidth()
                )
                Text(
                    text = "VS",
                    modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp)
                        .weight(1f),
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = Color(0x80FFFFFF),
                    )
                )
                TeamComponent(model = team2, modifier = Modifier.weight(2f))
            }

            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(
                    text = "Hoje, 21:00",
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = Color(0xFFFFFFFF)
                    )
                )
            }

            val opponents1 = detailResponse.playerDetailResponse.opponents.getOrNull(0)
            val opponents2 = detailResponse.playerDetailResponse.opponents.getOrNull(1)

            if (opponents1 != null && opponents2 != null) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.weight(1f)) {
                        opponents1.players.forEach { player ->
                            LeftSidePlayerComponent(player = player)
                        }
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    Column(modifier = Modifier.weight(1f)) {
                        opponents2.players.forEach { player ->
                            RightSidePlayerComponent(player = player)
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MatchDetailScreenPreview() {
    CSTVTheme {
        MatchDetailScreen(rememberNavController(), 1, "Title")
    }
}