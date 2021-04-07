package com.homebooking

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun LocationSelector() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text("Location")
        Spacer(Modifier.width(6.dp))
        Icon(
            Icons.Default.KeyboardArrowDown,
            "dropdown icon",
            Modifier.size(26.dp),
            Color.LightGray
        )
    }
}