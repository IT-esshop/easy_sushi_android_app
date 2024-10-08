package com.example.easysushi.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.easysushi.ui.theme.EasySushiColors.Green

private val DarkColorPalette = darkColors(
    primary = Green,
    primaryVariant = Color.White
)

private val LightColorPalette = lightColors(
    primary = Green,
    primaryVariant = Color.White
)

@Composable
fun EasySushiTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}