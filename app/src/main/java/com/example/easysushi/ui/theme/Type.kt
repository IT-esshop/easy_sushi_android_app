package com.example.easysushi.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.sp
import com.example.easysushi.R

val gothamFontMedium = FontFamily(
    Font(R.font.gothamcond_medium)
)

val gothamFontBook = FontFamily(
    Font(R.font.gothamcond_book)
)

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = gothamFontMedium,
        fontWeight = FontWeight(500),
        fontSize = 16.sp,
        color = EasySushiColors.Black,
        letterSpacing = TextUnit(value = 0f, type = TextUnitType.Sp)
    ),
    body2 = TextStyle(
        fontFamily = gothamFontBook,
        fontWeight = FontWeight(400),
        fontSize = 16.sp,
        color = EasySushiColors.Black,
        letterSpacing = TextUnit(value = 0f, type = TextUnitType.Sp)
    )
)
