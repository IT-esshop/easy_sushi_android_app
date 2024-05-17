package com.example.easysushi.core.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.TopEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.example.easysushi.R
import com.example.easysushi.ui.theme.EasySushiColors

@Composable
fun AddToCartButton(
    elementSize: Dp,
    waresInCart: Int,
    onAddToCardClicked: () -> Unit
) {
    Surface(
        modifier = Modifier
            .size(elementSize),
        color = Color.Transparent
    ) {
        Box(
            modifier = Modifier
                .size(elementSize * 0.85f),
            contentAlignment = Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_cart),
                contentDescription = "",
                tint = EasySushiColors.Black,
                modifier = Modifier
                    .size(elementSize * 0.8f)
                    .drawBehind {
                        drawCircle(
                            color = EasySushiColors.DarkYellow
                        )
                    }
                    .clickable(onClick = onAddToCardClicked)
                    .padding(elementSize * 0.15f)
            )
        }

        Box(
            modifier = Modifier
                .size(elementSize * 0.85f)
                .padding(end = elementSize * 0.12f),
            contentAlignment = TopEnd
        ) {
            if (waresInCart > 0) {
                Text(
                    text = waresInCart.toString(),
                    color = EasySushiColors.Green,
                    fontSize = TextUnit(value = elementSize.value * 0.3f, type = TextUnitType.Sp),
                    modifier = Modifier
                        .drawBehind {
                            drawCircle(
                                color = EasySushiColors.White,
                                radius = this.size.maxDimension / 2f
                            )
                        })
            }
        }
    }
}

@Preview
@Composable
private fun CartWithWaresPreview() {
    AddToCartButton(waresInCart = 1, onAddToCardClicked = {}, elementSize = 60.dp)
}

@Preview
@Composable
private fun EmptyCartPreview() {
    AddToCartButton(waresInCart = 0, onAddToCardClicked = {}, elementSize = 60.dp)
}


@Preview
@Composable
private fun EmptyCartSmallSizePreview() {
    AddToCartButton(waresInCart = 0, onAddToCardClicked = {}, elementSize = 30.dp)
}