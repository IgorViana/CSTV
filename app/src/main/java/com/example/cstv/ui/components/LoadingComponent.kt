package com.example.cstv.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LoadingComponent(modifier: Modifier = Modifier) {
    CircularProgressIndicator(modifier = modifier.size(50.dp))
}

@Preview(showBackground = true)
@Composable
fun LoadingComponentPreview() {
    LoadingComponent()
}