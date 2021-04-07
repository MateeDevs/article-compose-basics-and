package com.homebooking.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.homebooking.ui.home.houses.HouseList
import com.homebooking.ui.home.houses.PopularHouse

@Preview
@Composable
fun HomeScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        Header()
        Search()
        Spacer(Modifier.height(16.dp))
        HouseList()
        PopularHouse()
    }
}


