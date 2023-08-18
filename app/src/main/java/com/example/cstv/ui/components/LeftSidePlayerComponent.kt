package com.example.cstv.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.cstv.R
import com.example.cstv.model.player.PlayerModel

@Composable
fun LeftSidePlayerComponent(modifier: Modifier = Modifier, player: PlayerModel) {
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
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = player.name.orEmpty(), modifier = Modifier.padding(bottom = 8.dp),
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color(0xFFFFFFFF)
                ),
                maxLines = 1
            )
            Text(
                text = "${player.firstName.orEmpty()} ${player.lastName.orEmpty()}",
                style = TextStyle(
                    fontSize = 12.sp,
                    color = Color(0xFF6C6B7E)
                ),
                maxLines = 1
            )
        }
        AsyncImage(
            model = player.imageUrl,
            contentDescription = "Player's image",
            modifier = Modifier
                .size(50.dp)
                .align(Alignment.CenterVertically),
            placeholder = painterResource(id = R.drawable.rectangle_placeholder),
            error = painterResource(id = R.drawable.rectangle_placeholder),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LeftSidePlayerComponentPreview() {
    LeftSidePlayerComponent(
        player = PlayerModel(
            firstName = "dummy",
            lastName = "dummy",
            imageUrl = "dummy",
            slug = "dummy",
            name = "dummy"
        )
    )
}
