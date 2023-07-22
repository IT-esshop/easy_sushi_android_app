package com.example.easysushi.ui.wareslist

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.easysushi.domain.model.Ware


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun WaresScreen(
    viewModel: WaresViewModel = hiltViewModel()
) {
    val wareState by remember {
        mutableStateOf(viewModel.ware.value)
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        content = {
            items(10){
                for(index in 0..9){
                    ItemWare(ware = wareState[index])
                }
            }
        }
    )
}

@Composable
fun ItemWare(ware: Ware) {
    Card(
        modifier = Modifier
            .padding(5.dp)
            .clip(shape = RoundedCornerShape(6.dp)),

        elevation = 10.dp
    ) {
        Column {
            AsyncImage(
                modifier = Modifier
                    .padding(5.dp)
                    .size(150.dp),
                model = ware.imageUrl,
                contentDescription = ""
            )
            Text(
                modifier = Modifier
                    .padding(start = 10.dp),
                text = ware.name,
                color = Color.Black,
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    modifier = Modifier
                        .padding(start = 5.dp, bottom = 5.dp),
                    text = "${ware.price} ₽",
                    fontSize = 25.sp,
                    color = Color.Green
                )
                Button(
                    modifier = Modifier
                        .padding(end = 5.dp, bottom = 5.dp),
                    shape = RoundedCornerShape(20.dp),
                    onClick = { /*TODO*/ }
                ) {
                    Text(text = "BUY", fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Preview
@Composable
fun WaresScreenPreview() {
    WaresScreen()
}