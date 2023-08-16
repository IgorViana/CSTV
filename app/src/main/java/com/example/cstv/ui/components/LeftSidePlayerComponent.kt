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
import com.example.cstv.model.playersDetail.Player

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
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = player.slug, modifier = Modifier.padding(bottom = 8.dp),
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color(0xFFFFFFFF)
                )
            )
            Text(
                text = player.first_name + player.last_name,
                style = TextStyle(
                    fontSize = 12.sp,
                    color = Color(0xFF6C6B7E)
                )
            )
        }
        AsyncImage(
            model = player.image_url,
            contentDescription = "Player's image",
            modifier = Modifier
                .size(50.dp)
                .align(Alignment.CenterVertically),
            placeholder = painterResource(id = R.drawable.rectangle_placeholder),
            error = painterResource(id = R.drawable.rectangle_placeholder),
            contentScale = ContentScale.Fit
        )
    }
}
@Preview(showBackground = true)
@Composable
fun LeftSidePlayerComponentPreview() {
    LeftSidePlayerComponent(
        player = Player(
            age = 0,
            birthday = "",
            first_name = null,
            id = 0,
            image_url = "",
            last_name = null,
            modified_at = "",
            name = "",
            nationality = "",
            role = "",
            slug = ""
        )
    )
}
