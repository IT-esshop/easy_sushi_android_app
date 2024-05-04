package com.example.easysushi.ui.userprofile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.easysushi.R
import com.example.easysushi.domain.model.User
import com.example.easysushi.domain.model.UserPromotion

@Composable
fun UserProfileScreen(viewModel: UserProfileViewModel = hiltViewModel()) {
    UserProfileScreenContent(
        user = viewModel.user.value,
        activatePromo = viewModel::activatePromo
    )
}

@Composable
fun UserProfileScreenContent(
    user: User,
    activatePromo: (Long) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        UserBlock(user)
        PointsBlock(user)
        PromotionsBlock(
            userPromotions = user.userPromotions,
            activatePromo = activatePromo
        )
        PersonalStaff()
    }
}

@Composable
fun UserBlock(
    user: User
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        AsyncImage(model = user.avatarUrl, contentDescription = "user_icon")
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(
                text = stringResource(id = R.string.hello_username, user.name)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(id = R.string.we_wish_you_a_great_day)
            )
        }
    }
}

@Composable
fun PointsBlock(
    user: User
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Column {
            Text(text = stringResource(id = R.string.active_points))
            Text(text = user.cashbackPoints.toString())
        }
    }
}

@Composable
fun PromotionsBlock(
    userPromotions: List<UserPromotion>,
    activatePromo: (Long) -> Unit
) {
    LazyRow(modifier = Modifier.fillMaxWidth()) {
        items(userPromotions.size) {
            PromotionsItem(
                userPromotion = userPromotions[it],
                activatePromo = activatePromo
            )
        }
    }
}

@Composable
fun PromotionsItem(
    userPromotion: UserPromotion,
    activatePromo: (Long) -> Unit
) {
    // TODO Подумать как сделать высоту карточки размером с высоту LazyRow родительского
    Card(
        modifier = Modifier.size(width = 280.dp, height = 100.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(8.dp)) {
            AsyncImage(
                model = userPromotion.imageUrl
                    ?: painterResource(id = R.drawable.map_pointer_easysushi),
                contentDescription = "promo_image"
            )
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    elevation = ButtonDefaults.elevation(defaultElevation = 4.dp),
                    onClick = { activatePromo(userPromotion.promotionId) }
                ) {
                    Text(text = stringResource(id = R.string.activate_promo))
                }
                Text(
                    text = userPromotion.text,
                    maxLines = 2,
                    color = Color.Black,
                    fontSize = 12.sp,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Composable
fun PersonalStaff(modifier: Modifier = Modifier) {

}

@Preview
@Composable
fun PromotionItemPreview() {
    PromotionsItem(
        userPromotion = UserPromotion.stubUserPromotion.copy(imageUrl = null),
        activatePromo = {}
    )
}
