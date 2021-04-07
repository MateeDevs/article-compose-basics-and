package com.homebooking.ui.home.houses

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun Rating(value: Int, modifier: Modifier = Modifier) {
    val starColor = Color(0xFFFFA235)

    Row(modifier) {
        repeat(5) { position ->
            Icon(
                Icons.Rounded.Star,
                "",
                tint = starColor,
                modifier = Modifier
                    .requiredSize(22.dp)
                    .alpha(if (position + 1 > value) 0.3f else 1f),
            )
        }
    }
}