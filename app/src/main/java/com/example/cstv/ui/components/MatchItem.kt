package com.example.cstv.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.cstv.R
import com.example.cstv.model.match.LeagueModel
import com.example.cstv.model.match.MatchModel
import com.example.cstv.model.match.TeamModel
import com.example.cstv.util.formatDate

@Composable
fun MatchItem(
    modifier: Modifier = Modifier,
    item: MatchModel,
    onMatchClick: (matchId: Long, title: String) -> Unit = { _, _ -> }
) {
    val title = item.league.name.orEmpty() + " + " + item.seriesName.orEmpty()
    Card(
        colors = CardDefaults.cardColors(containerColor = Color(0xFF272639)),
        modifier = modifier
            .padding(vertical = 12.dp, horizontal = 24.dp)
            .fillMaxWidth()
            .clickable { onMatchClick(item.matchId, title) },
        shape = RoundedCornerShape(16.dp)
    ) {
        Column {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopEnd) {
                Text(
                    text = if (item.status == stringResource(R.string.running)) stringResource(R.string.agora)
                    else formatDate(item.beginAt),
                    modifier = Modifier
                        .background(
                            color = if (item.status == stringResource(R.string.running)) Color(
                                0xFFF42A35
                            )
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
                verticalAlignment = Alignment.CenterVertically
            ) {

                val opponent1: TeamModel? = item.teams?.getOrNull(0)
                val opponent2: TeamModel? = item.teams?.getOrNull(1)

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
        item = MatchModel(
            beginAt = null,
            status = "maiorum",
            teams = listOf(),
            league = LeagueModel(name = null, imageUrl = null),
            seriesName = null,
            matchId = 1
        )
    )
}