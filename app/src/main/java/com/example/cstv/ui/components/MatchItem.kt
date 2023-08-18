package com.example.cstv.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.cstv.R
import com.example.cstv.networking.response.match.League
import com.example.cstv.networking.response.match.Live
import com.example.cstv.networking.response.match.MatchResponseItem
import com.example.cstv.networking.response.match.Opponent
import com.example.cstv.networking.response.match.OpponentX
import com.example.cstv.networking.response.match.Serie
import com.example.cstv.networking.response.match.Tournament
import com.example.cstv.networking.response.match.Videogame
import com.example.cstv.networking.response.match.WinnerX
import com.example.cstv.util.formatDate

@Composable
fun MatchItem(
    modifier: Modifier = Modifier,
    item: MatchResponseItem,
    onMatchClick: (matchId: Long, title: String) -> Unit = { _, _ -> }
) {
    val title = item.league.name + " + " + item.serie.name.orEmpty()
    Card(
        colors = CardDefaults.cardColors(containerColor = Color(0xFF272639)),
        modifier = modifier
            .padding(vertical = 12.dp, horizontal = 24.dp)
            .fillMaxWidth()
            .clickable { onMatchClick(item.games[0].matchId, title) },
        shape = RoundedCornerShape(16.dp)
    ) {
        Column {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopEnd) {
                Text(
                    text = if (item.status == "running") "AGORA" else formatDate(item.beginAt),
                    modifier = Modifier
                        .background(
                            color = if (item.status == "running") Color(0xFFF42A35)
                            else Color(0x33FAFAFA),
                            shape = RoundedCornerShape(bottomStart = 16.dp)
                        )
                        .padding(8.dp),
                    style = TextStyle(
                        fontSize = 8.sp,
                        color = Color(0xFFFFFFFF),
                        textAlign = TextAlign.Center,
                    )
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                val opponent1: OpponentX? = item.opponents?.getOrNull(0)?.opponent
                val opponent2: OpponentX? = item.opponents?.getOrNull(1)?.opponent

                TeamComponent(model = opponent1, modifier = Modifier.weight(2f))
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
                TeamComponent(model = opponent2, modifier = Modifier.weight(2f))

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
                    model = item.league.imageUrl,
                    contentDescription = "League's image",
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .size(16.dp),
                    placeholder = painterResource(id = R.drawable.placeholder_icon),
                    error = painterResource(id = R.drawable.placeholder_icon)
                )
                Text(
                    text = title,
                    style = TextStyle(
                        fontSize = 8.sp,
                        color = Color(0xFFFFFFFF)
                    )
                )
            }
        }
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
            gameAdvantage = 1,
            games = listOf(),
            id = 2046,
            league = League(
                id = 7798,
                imageUrl = "https://duckduckgo.com/?q=ludus",
                modifiedAt = "postea",
                name = "Josue Sellers",
                slug = "aeque",
                url = "http://www.bing.com/search?q=rutrum"
            ),
            leagueId = 7480,
            live = Live(opensAt = "", supported = false, url = ""),
            matchType = "an",
            modifiedAt = "hac",
            name = "Isabelle Horton",
            numberOfGames = 2322,
            opponents = listOf(
                Opponent(
                    opponent = OpponentX(
                        acronym = "",
                        id = 5152,
                        imageUrl = "https://duckduckgo.com/?q=verear",
                        location = "turpis",
                        modifiedAt = "sadipscing",
                        name = "Kirby Espinoza",
                        slug = "animal"
                    ),
                    type = "Time"
                ),
                Opponent(
                    opponent = OpponentX(
                        acronym = "",
                        id = 5152,
                        imageUrl = "https://duckduckgo.com/?q=verear",
                        location = "turpis",
                        modifiedAt = "sadipscing",
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
                beginAt = "elaboraret",
                endAt = "adversarium",
                fullName = "Evangelina Puckett",
                id = 4446,
                leagueId = 7631,
                modifiedAt = "quaerendum",
                name = "Alyce Russo",
                season = "dolore",
                slug = "iisque",
                winnerId = 9714,
                winnerType = "facilisi",
                year = 2013
            ),
            serieId = 8028,
            slug = "vocent",
            status = "volumus",
            streamsList = listOf(),
            tournament = Tournament(
                beginAt = "signiferumque",
                detailedStats = false,
                endAt = "quo",
                hasBracket = false,
                id = 4077,
                leagueId = 6103,
                liveSupported = false,
                modifiedAt = "quem",
                name = "Sheryl Morrow",
                prizepool = "scripserit",
                serieId = 9816,
                slug = "mutat",
                tier = "eloquentiam",
                winnerId = 6150,
                winnerType = "duo"
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
                imageUrl = "https://duckduckgo.com/?q=deserunt",
                location = "quis",
                modifiedAt = "auctor",
                name = "Ines Bryan",
                slug = "curabitur"
            ),
            winnerId = 5147,
            winnerType = "saperet"
        )
    )
}