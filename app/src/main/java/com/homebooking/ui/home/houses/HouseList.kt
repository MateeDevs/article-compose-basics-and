package com.homebooking.ui.home.houses

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
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
import androidx.compose.ui.unit.sp
import com.google.accompanist.coil.CoilImage

@Preview(showBackground = false)
@Composable
fun HouseList() {
    LazyRow(
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(houseItems) {
            HouseCard(house = it)
        }
    }
}

@Composable
fun HouseCard(house: House) {
    Surface(shape = MaterialTheme.shapes.large, modifier = Modifier.width(300.dp)) {
        Column(Modifier.padding(16.dp)) {
            HouseImage(house)
            Spacer(Modifier.height(16.dp))
            HouseInfo(house)
            Spacer(Modifier.height(12.dp))
            HouseFeatureList(house)
        }
    }
}

@Composable
fun HouseImage(house: House) {
    CoilImage(
        data = house.pictureUrl,
        contentDescription = "Picture of ${house.name} house",
        fadeIn = true,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(10 / 9f)
            .clip(MaterialTheme.shapes.medium)
    )
}

@Composable
fun HouseInfo(house: House) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Column(Modifier.weight(0.1f)) {
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
        Spacer(modifier = Modifier.width(8.dp))
        Rating(house.rating)
    }
}

@Composable
fun HouseFeatureList(house: House) {
    Row(Modifier.height(32.dp)) {
        house.features.forEach {
            HouseFeature(it)
            Spacer(Modifier.width(8.dp))
        }

        Surface(
            color = MaterialTheme.colors.primary,
            shape = MaterialTheme.shapes.small,
            modifier = Modifier
                .fillMaxHeight()
                .aspectRatio(1f)
                .clickable { }
        ) {
            Icon(
                Icons.Default.KeyboardArrowRight,
                contentDescription = "Next features",
                Modifier.padding(4.dp),
                tint = MaterialTheme.colors.onPrimary
            )
        }
    }
}

@Composable
fun HouseFeature(houseFeature: HouseFeature) {
    Row(
        Modifier
            .fillMaxHeight()
            .clip(MaterialTheme.shapes.small)
            .background(Color.LightGray.copy(alpha = 0.05f))
            .border(1.dp, Color.LightGray, MaterialTheme.shapes.small)
            .padding(vertical = 4.dp, horizontal = 12.dp)
    ) {
        Icon(
            houseFeature.icon,
            contentDescription = houseFeature.text,
            tint = MaterialTheme.colors.primary,
            modifier = Modifier
                .size(18.dp)
                .align(Alignment.CenterVertically)
        )
        Spacer(Modifier.width(8.dp))
        Text(
            houseFeature.text,
            Modifier.align(Alignment.CenterVertically),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
    }
}