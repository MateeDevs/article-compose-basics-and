package com.homebooking.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun Header() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(24.dp),
        Arrangement.SpaceBetween
    ) {
        Column {
            LocationSelector()
            Spacer(modifier = Modifier.height(10.dp))
            LocationValue("Solo, Indonesia")
        }
        NotificationButton()
    }
}

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

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun LocationValue(location: String = "Location") {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = Icons.Rounded.LocationOn,
            contentDescription = "location",
            tint = MaterialTheme.colors.primary,
            modifier = Modifier.size(32.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = location,
            style = TextStyle(
                fontSize = 28.sp,
                fontWeight = FontWeight.W500,
                fontFamily = FontFamily.SansSerif
            )
        )
    }
}

@Preview
@Composable
fun NotificationButton(modifier: Modifier = Modifier) {
    Icon(
        imageVector = Icons.Rounded.Notifications,
        contentDescription = "notifications",
        modifier = modifier
            .background(MaterialTheme.colors.surface, MaterialTheme.shapes.medium)
            .padding(6.dp)
            .size(32.dp)
            .withNotificationDot()
    )
}

fun Modifier.withNotificationDot(dotRadius: Dp = 4.dp) = composed {
    val primaryColor = MaterialTheme.colors.primary
    val surfaceColor = MaterialTheme.colors.surface

    drawWithContent {
        val dotCenter = Offset(size.width * 0.70f, size.height * 0.25f)
        val dotRadiusValue = dotRadius.value * density

        // draw our notification bell with the background
        drawContent()

        // draw slightly bigger circle as the white outline
        drawCircle(surfaceColor, dotRadiusValue * 1.2f, dotCenter)

        // draw the dot itself
        drawCircle(primaryColor, dotRadiusValue, dotCenter)
    }
}