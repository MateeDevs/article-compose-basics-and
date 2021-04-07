package com.homebooking.ui.home.houses

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.CoilImage

@Preview
@Composable
fun PopularHouse() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "Popular House",
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(16.dp))
        HouseItem(houseItems[1])
    }
}

@Composable
fun HouseItem(house: House) {
    Surface(
        shape = MaterialTheme.shapes.large,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(Modifier.padding(16.dp)) {
            CoilImage(
                data = house.pictureUrl,
                contentDescription = "Picture of ${house.name} house",
                fadeIn = true,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(96.dp)
                    .clip(MaterialTheme.shapes.medium)
            )
            Spacer(Modifier.width(22.dp))
            HouseInfo(house = house, false, Modifier.align(Alignment.CenterVertically))
        }
    }
}

@Composable
fun HouseInfo(house: House, horizontal: Boolean, modifier: Modifier = Modifier) {
    val content: @Composable (Modifier) -> Unit = { modifier ->
        Column(modifier) {
            Text(
                text = house.name,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = house.location,
                style = MaterialTheme.typography.subtitle2.copy(color = Color.LightGray)
            )
        }
        Spacer(modifier = Modifier.size(8.dp))
        Rating(house.rating)
    }

    if (horizontal)
        Row(modifier.fillMaxWidth(), Arrangement.SpaceBetween) {
            content(Modifier.weight(0.1f))
        }
    else
        Column(modifier.fillMaxWidth()) { content(Modifier) }
}