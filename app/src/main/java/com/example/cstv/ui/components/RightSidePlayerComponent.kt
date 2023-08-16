package com.example.cstv.ui.components

import androidx.compose.foundation.background
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.cstv.R
import com.example.cstv.model.playersDetail.Player

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
            modifier = Modifier.size(50.dp),
            placeholder = painterResource(id = R.drawable.rectangle_placeholder),
            error = painterResource(id = R.drawable.rectangle_placeholder)
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