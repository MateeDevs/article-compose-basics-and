package com.homebooking.ui.home.houses

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bed
import androidx.compose.material.icons.filled.Wifi
import androidx.compose.ui.graphics.vector.ImageVector

data class House(
    val name: String,
    val pictureUrl: String,
    val location: String,
    val rating: Int,
    val features: List<HouseFeature>
)

sealed class HouseFeature(val icon: ImageVector, val text: String) {
    class Bedrooms(count: Int) : HouseFeature(Icons.Default.Bed, "$count Bedroom")
    object WiFi : HouseFeature(Icons.Default.Wifi, "WiFi")
}

val houseItems = listOf(
    House(
        "The Sile House",
        "https://a3w3j4i7.stackpathcdn.com/wp-content/uploads/2020/04/The-Sile-House-1.jpg",
        "Mojolaban, Solo",
        3,
        listOf(HouseFeature.Bedrooms(2), HouseFeature.WiFi)
    ),
    House(
        "Matraville Residence",
        "https://a3w3j4i7.stackpathcdn.com/wp-content/uploads/2020/08/1-6-19.jpg",
        "Mojolaban, Solo",
        4,
        listOf(HouseFeature.Bedrooms(3), HouseFeature.WiFi)
    )
)