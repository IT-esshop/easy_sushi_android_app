package com.example.easysushi.ui.wareslist

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.easysushi.core.UiComponent
import com.example.easysushi.domain.model.Ware
import com.example.easysushi.domain.model.WareCategory
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect
import kotlin.random.Random

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun WaresScreen(
    viewModel: WaresViewModel = hiltViewModel()
) {
    val state by viewModel.collectAsState()
    val context = LocalContext.current

    WaresScreenContent(state)

    viewModel.collectSideEffect { uiComponent ->
        when (uiComponent) {
            is UiComponent.Toast -> {
                Toast.makeText(context, uiComponent.text, Toast.LENGTH_SHORT).show()
            }

            else -> {}
        }
    }
}

@Composable
private fun WaresScreenContent(
    state: WaresState
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2)
    ) {
        items(state.wares) {
            ItemWare(ware = it)
        }
    }

    if (state.progressBar) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
}

@Composable
private fun ItemWare(ware: Ware) {
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

@Preview()
@Composable
fun WaresScreenPreview() {
    val waresList = mutableListOf<Ware>()
    val exampleWare = Ware(
        id = 1,
        name = "Спайси тунец",
        wareCategory = WareCategory.ROLLS,
        price = 169,
        composition = "Рис, водоросли Нори, шичими, сливочный сыр, омлет тамаго, тунец, соус Чили",
        weight = 175,
        kcal = 214,
        protein = 9,
        fat = 7,
        carbohydrates = 29,
        imageUrl = "https://www.sushieasy.ru/assets/images/cache/docs/103315/tartar.png/1685698217/320.png"
    )
    repeat(20) {
        waresList.add(exampleWare)
    }
    WaresScreenContent(
        state = WaresState(
            wares = waresList
        )
    )
}
