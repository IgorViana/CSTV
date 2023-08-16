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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.cstv.R
import com.example.cstv.model.matches.League
import com.example.cstv.model.matches.Live
import com.example.cstv.model.matches.MatchResponseItem
import com.example.cstv.model.matches.Opponent
import com.example.cstv.model.matches.OpponentX
import com.example.cstv.model.matches.Serie
import com.example.cstv.model.matches.Tournament
import com.example.cstv.model.matches.Videogame
import com.example.cstv.model.matches.WinnerX
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

@Composable
fun MatchItem(
    modifier: Modifier = Modifier,
    item: MatchResponseItem,
    onMatchClick: (matchId: Long) -> Unit = {}
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF272639),
        ),
        modifier = modifier
            .padding(vertical = 12.dp, horizontal = 24.dp)
            .fillMaxWidth()
            .clickable { onMatchClick(item.id) },
        shape = RoundedCornerShape(16.dp)
    ) {
        Column {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopEnd) {
                Text(
                    text = if (item.status == "running") "AGORA" else "Hoje, 21:00",
                    modifier = Modifier
                        .background(
                            color = if (item.status == "running") Color(0xFFF42A35)
                            else Color(0x33FAFAFA),
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
                var opponent1: OpponentX? = null
                var opponent2: OpponentX? = null
                if (item.opponents.size >= 2) {
                    opponent1 = item.opponents[0].opponent
                    opponent2 = item.opponents[1].opponent
                }
                TeamComponent(model = opponent1, modifier = Modifier.weight(2f))
                Text(
                    text = "VS",
                    modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp)
                        .weight(1f)
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
                    model = item.league.image_url,
                    contentDescription = "League's image",
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .size(16.dp),
                    placeholder = painterResource(id = R.drawable.placeholder_icon),
                    error = painterResource(id = R.drawable.placeholder_icon)
                )
                Text(text = item.league.name + " " + item.serie.name)
            }
        }
    }
}


private fun FormatDate(date: String) {

    val currentDate = Calendar.getInstance()

    val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm.SSSZ")
    val formatted: Date = formatter.parse(date)
    val calendar = Calendar.getInstance()
    calendar.time = formatted

    val today = SimpleDateFormat("HH:mm")
    val week = SimpleDateFormat("EEEE,HH:mm")
    val other = SimpleDateFormat("dd.mm HH:mm")

    if (currentDate.time.day == calendar.time.day) {
        val timeFormatted: String = "Hoje " + today.format(calendar.time)
    }

    val year1: Int = currentDate.get(currentDate.weekYear)
    val week1: Int = currentDate.get(currentDate.weeksInWeekYear)
    val year2: Int = calendar.get(calendar.weekYear)
    val week2: Int = calendar.get(calendar.weeksInWeekYear)

    if (year1 == year2 && week1 == week2) {
        val timeFormatted: String = week.format(calendar.time)
    } else {
        val timeFormatted: String = other.format(calendar.time)
    }

    val now = "AGORA"
}

@Composable
fun TeamComponent(modifier: Modifier = Modifier, model: OpponentX?) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        AsyncImage(
            model = model?.image_url,
            contentDescription = "Team flag",
            modifier = Modifier.size(width = 53.dp, height = 60.dp),
            placeholder = painterResource(id = R.drawable.placeholder_icon),
            error = painterResource(id = R.drawable.placeholder_icon)
        )
        Text(text = model?.name.orEmpty(), modifier = Modifier.padding(top = 10.dp))
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