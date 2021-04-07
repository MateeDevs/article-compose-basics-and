package com.homebooking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.homebooking.ui.home.HomeScreen

class MainActivity : ComponentActivity() {
    private val lightColorPalette = lightColors(
        primary = Color(0xFFFE6876),
        background = Color(0xFFF2F3F6),
        surface = Color(0xFFFCFDFE),
    )

    private val shapes = Shapes(
        small = RoundedCornerShape(10.dp),
        medium = RoundedCornerShape(12.dp),
        large = RoundedCornerShape(16.dp)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(
                colors = lightColorPalette,
                shapes = shapes
            ) {
                HomeScreen()
            }
        }
    }
}