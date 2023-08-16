package com.example.cstv.ui.screen.matchDetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
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
import coil.compose.AsyncImage
import com.example.cstv.model.matches.OpponentX
import com.example.cstv.model.playersDetail.Player
import com.example.cstv.ui.components.TeamComponent
import com.example.cstv.ui.theme.CSTVTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MatchDetailScreen(navController: NavController, matchId: Long) {

    val viewModel: MatchDetailViewModel = hiltViewModel()
    val state = viewModel.state.collectAsState()


    val dummy = OpponentX(
        acronym = "",
        id = 1471,
        image_url = "https://search.yahoo.com/search?p=moderatius",
        location = "aptent",
        modified_at = "tractatos",
        name = "Ignacio Daniel",
        slug = "corrumpit"
    )

    Column(modifier = Modifier.fillMaxSize()) {

        TopAppBar(
            title = {
                Text("League + Serie")
            },
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(Icons.Filled.ArrowBack, null)
                }
            })

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            TeamComponent(
                model = dummy, modifier = Modifier
                    .weight(2f)
                    .fillMaxWidth()
            )
            Text(
                text = "VS",
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp)
                    .weight(1f)
            )
            TeamComponent(model = dummy, modifier = Modifier.weight(2f))
        }

        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Text(text = "Hoje, 21:00")
        }

        val team1 = state.value.matches?.opponents?.get(0)
        val team2 = state.value.matches?.opponents?.get(1)

        if (team1 != null && team2 != null) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.weight(1f)) {
                    team1.players.forEach { player ->
                        LeftSidePlayerComponent(player = player)
                    }

                }

                Column(modifier = Modifier.weight(1f)) {
                    team2.players.forEach { player ->
                        RightSidePlayerComponent(player = player)
                    }
                }
            }
        }
    }
}

@Composable
fun LeftSidePlayerComponent(modifier: Modifier = Modifier, player: Player) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(
                color = Color(0xFF272639),
                shape = RoundedCornerShape(topEnd = 12.dp, bottomEnd = 12.dp)
            )
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(end = 16.dp, bottom = 8.dp, top = 8.dp),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = player.slug, modifier = Modifier.padding(bottom = 8.dp))
            Text(text = player.first_name + player.last_name)
        }
        AsyncImage(
            model = player.image_url,
            contentDescription = "Player's image",
            modifier = Modifier.size(50.dp)
        )
    }
}

@Composable
fun RightSidePlayerComponent(modifier: Modifier = Modifier, player: Player) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(
                color = Color(0xFF272639),
                shape = RoundedCornerShape(topStart = 12.dp, bottomStart = 12.dp)
            )
    ) {
        AsyncImage(
            model = player.image_url,
            contentDescription = "Players image",
            modifier = Modifier.size(50.dp)
        )

        Column(
            modifier = Modifier
                .weight(1f),
            horizontalAlignment = Alignment.End
        ) {
            Text(text = player.slug)
            Text(text = player.first_name + player.last_name)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MatchDetailScreenPreview() {
    CSTVTheme {
        MatchDetailScreen(rememberNavController(), 1)
    }
}