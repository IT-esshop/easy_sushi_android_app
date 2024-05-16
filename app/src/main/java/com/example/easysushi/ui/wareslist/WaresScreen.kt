package com.example.easysushi.ui.wareslist

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.easysushi.R
import com.example.easysushi.core.EasySpinner
import com.example.easysushi.domain.model.Ware
import com.example.easysushi.domain.model.WareCategory
import com.example.easysushi.ui.theme.EasySushiColors
import com.example.easysushi.ui.theme.Typography

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun WaresScreen(
    viewModel: WaresViewModel = hiltViewModel()
) {
    val waresList by viewModel.waresList.collectAsState()
    val loaderState = viewModel.loaderState.collectAsState()

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        EasySpinner(state = loaderState.value)
    }

    WaresScreenContent(waresList)
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
private fun WaresScreenContent(
    waresList: List<Ware>
) {
    Scaffold(
        topBar = {
            TopAppBar(
                elevation = 4.dp,
                backgroundColor = EasySushiColors.Green,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "title logo",
                    modifier = Modifier.size(width = 130.dp, height = 30.dp)
                )
            }
        },
        floatingActionButton = {
            Button(
                onClick = { /*TODO*/ },
                shape = CircleShape,
                modifier = Modifier.size(45.dp),
                contentPadding = PaddingValues(4.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = EasySushiColors.DarkYellow),
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_cart),
                    contentDescription = ""
                )
            }
        }
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2)
        ) {
            items(waresList) { ware ->
                ItemWare(ware = ware)
            }
        }
    }
}

@Composable
private fun ItemWare(ware: Ware) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .shadow(elevation = 10.dp, clip = true)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                modifier = Modifier
                    .padding(5.dp)
                    .size(width = 130.dp, height = 80.dp),
                model = ware.imageUrl,
                contentDescription = ""
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = ware.name,
                    style = Typography.body1,
                    fontSize = 18.sp,
                    color = EasySushiColors.black,
                    maxLines = 2
                )
                Text(
                    text = stringResource(id = R.string.ware_weight_title, ware.weight),
                    style = Typography.body2,
                    fontSize = 14.sp,
                    color = EasySushiColors.lightGray,
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = stringResource(id = R.string.ware_price_title, ware.price),
                        style = Typography.body1,
                        fontSize = 24.sp,
                        color = EasySushiColors.Green,
                        textAlign = TextAlign.Start
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Button(
                        colors = ButtonDefaults.textButtonColors(backgroundColor = EasySushiColors.DarkYellow),
                        shape = RoundedCornerShape(10.dp),
                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                        onClick = { /*TODO*/ }
                    ) {
                        Text(
                            text = stringResource(id = R.string.add_into_cart),
                            style = Typography.body1,
                            color = EasySushiColors.white,
                            fontSize = 18.sp
                        )
                    }
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
        name = "Это набор из большого количества роллов, чтобы проверить вместимость текста",
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
    WaresScreenContent(waresList)
}
