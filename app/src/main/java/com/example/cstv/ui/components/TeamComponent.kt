package com.example.cstv.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.cstv.R
import com.example.cstv.model.matches.OpponentX

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
        Text(
            text = model?.name.orEmpty(),
            modifier = Modifier.padding(top = 10.dp),
            style = TextStyle(
                fontSize = 10.sp,
                color = Color(0xFFFFFFFF),
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TeamComponentPreview() {
    TeamComponent(model = null)
}
