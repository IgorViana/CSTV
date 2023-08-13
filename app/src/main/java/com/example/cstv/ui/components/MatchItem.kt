package com.example.cstv.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.cstv.model.League
import com.example.cstv.model.Live
import com.example.cstv.model.MatchResponseItem
import com.example.cstv.model.Opponent
import com.example.cstv.model.OpponentX
import com.example.cstv.model.Serie
import com.example.cstv.model.Tournament
import com.example.cstv.model.Videogame
import com.example.cstv.model.WinnerX

@Composable
fun MatchItem(modifier: Modifier = Modifier, item: MatchResponseItem) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF272639),
        ),
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopEnd) {
                Text(
                    text = "AGORA",
                    modifier = Modifier
                        .background(
                            color = Color.Red,
                            shape = RoundedCornerShape(bottomStart = 16.dp)
                        )
                        .padding(8.dp)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                // check if exists
                if(item.opponents.size >=2){
                    val opponent1 = item.opponents[0].opponent
                    val opponent2 = item.opponents[1].opponent
                    TeamComponent(model = opponent1)
                    Text(text = "VS", modifier = Modifier.padding(start = 20.dp, end = 20.dp))
                    TeamComponent(model = opponent2)
                }
            }
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Color(color = 0x33FFFFFF))
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model = item.league.image_url,
                    contentDescription = "League's image",
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .size(16.dp),
                    // placeholder = painterResource(id = R.drawable.fuze_logo)
                )
                Text(text = item.league.name + " " + item.serie.name)
            }
        }
    }
}

@Composable
fun TeamComponent(modifier: Modifier = Modifier, model: OpponentX) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        AsyncImage(
            model = model.image_url,
            contentDescription = "Team flag",
            modifier = Modifier.size(width = 53.dp, height = 60.dp)
        )
        Text(text = model.name, modifier = Modifier.padding(top = 10.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun MatchItemPreview() {
    MatchItem(
        item = MatchResponseItem(
            beginAt = "pro",
            detailedStats = false,
            draw = false,
            endAt = "fabulas",
            forfeit = false,
            gameAdvantage = "",
            games = listOf(),
            id = 2046,
            league = League(
                id = 7798,
                image_url = "https://duckduckgo.com/?q=ludus",
                modified_at = "postea",
                name = "Josue Sellers",
                slug = "aeque",
                url = "http://www.bing.com/search?q=rutrum"
            ),
            leagueId = 7480,
            live = Live(opens_at = "", supported = false, url = ""),
            matchType = "an",
            modifiedAt = "hac",
            name = "Isabelle Horton",
            numberOfGames = 2322,
            opponents = listOf(
                Opponent(
                    opponent = OpponentX(
                        acronym = "",
                        id = 5152,
                        image_url = "https://duckduckgo.com/?q=verear",
                        location = "turpis",
                        modified_at = "sadipscing",
                        name = "Kirby Espinoza",
                        slug = "animal"
                    ),
                    type = "Time"
                ),
                Opponent(
                    opponent = OpponentX(
                        acronym = "",
                        id = 5152,
                        image_url = "https://duckduckgo.com/?q=verear",
                        location = "turpis",
                        modified_at = "sadipscing",
                        name = "Kirby Espinoza",
                        slug = "animal"
                    ),
                    type = "Time"
                )

            ),
            originalScheduledAt = "reque",
            rescheduled = false,
            results = listOf(),
            scheduledAt = "sonet",
            serie = Serie(
                begin_at = "elaboraret",
                end_at = "adversarium",
                full_name = "Evangelina Puckett",
                id = 4446,
                league_id = 7631,
                modified_at = "quaerendum",
                name = "Alyce Russo",
                season = "dolore",
                slug = "iisque",
                winner_id = 9714,
                winner_type = "facilisi",
                year = 2013
            ),
            serieId = 8028,
            slug = "vocent",
            status = "volumus",
            streamsList = listOf(),
            tournament = Tournament(
                begin_at = "signiferumque",
                detailed_stats = false,
                end_at = "quo",
                has_bracket = false,
                id = 4077,
                league_id = 6103,
                live_supported = false,
                modified_at = "quem",
                name = "Sheryl Morrow",
                prizepool = "scripserit",
                serie_id = 9816,
                slug = "mutat",
                tier = "eloquentiam",
                winner_id = 6150,
                winner_type = "duo"
            ),
            tournamentId = 4683,
            videogame = Videogame(
                id = 5179,
                name = "Michel Preston",
                slug = "molestiae"
            ),
            videogameVersion = "",
            winner = WinnerX(
                acronym = "",
                id = 7493,
                image_url = "https://duckduckgo.com/?q=deserunt",
                location = "quis",
                modified_at = "auctor",
                name = "Ines Bryan",
                slug = "curabitur"
            ),
            winnerId = 5147,
            winnerType = "saperet"
        )
    )
}