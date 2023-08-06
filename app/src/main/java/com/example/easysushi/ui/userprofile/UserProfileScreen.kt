package com.example.easysushi.ui.userprofile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.easysushi.R

@Composable
fun UserProfileScreen(
    viewModel: UserProfileViewModel = hiltViewModel()
) {
    UserProfileContent(
        userName = viewModel.userName,
        bonusProgramStatus = viewModel.bonusProgramStatus,
        ordersQuantity = viewModel.ordersQuantity,
        userPhoneNumber = viewModel.userPhoneNumber
    )
    // TODO Нужно создать модель данных для UI и подавать в экран с Контентом сразу модель
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun UserProfileContent(
    userName: State<String>,
    bonusProgramStatus: State<BonusProgramUserStatus>,
    ordersQuantity: State<Int>,
    userPhoneNumber: State<String>,
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) { scaffoldPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "User avatar",
                modifier = Modifier
                    .padding(scaffoldPadding)
                    .size(150.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = userName.value
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = userPhoneNumber.value)
            Spacer(modifier = Modifier.height(16.dp))
            Card(
                elevation = 6.dp,
                onClick = {}, // TODO
                modifier = Modifier.padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Column {
                        Text(text = stringResource(id = bonusProgramStatus.value.statusTitle))
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = stringResource(
                                id = R.string.user_profile_orders_quantity,
                                ordersQuantity.value.toString()
                            )
                        )
                    }
                    Spacer(modifier = Modifier
                        .height(32.dp)
                        .weight(1f))
                    Text(text = bonusProgramStatus.value.discountPercentage.toString() + " %")
                }
            }
        }
    }
}

@Preview
@Composable
fun UserProfilePreview() {
    UserProfileContent(
        userName = remember { mutableStateOf("Test user name") },
        bonusProgramStatus = remember { mutableStateOf(BonusProgramUserStatus.MEDIUM) },
        ordersQuantity = remember { mutableStateOf(5) },
        userPhoneNumber = remember { mutableStateOf("+7 (999) 888-88-88 ") }
    )
}