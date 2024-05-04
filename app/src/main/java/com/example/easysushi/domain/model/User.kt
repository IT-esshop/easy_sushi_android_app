package com.example.easysushi.domain.model

data class User(
    val userId: Long,
    val name: String,
    val surname: String,
    val birthDate: String,
    val phoneNumber: String,
    val discountPercentage: Int,
    val ordersQuantity: Int,
    val cashbackPoints: Long,
    val userPromotions: List<UserPromotion>,
    val avatarUrl: String,
) {
    companion object {
        val stubUser = User(
            userId = 1,
            name = "Masha",
            surname = "Nazarova",
            birthDate = "01.01.2001",
            phoneNumber = "7 999 999 99 99",
            discountPercentage = 20,
            ordersQuantity = 10,
            cashbackPoints = 127,
            userPromotions = listOf(
                UserPromotion.stubUserPromotion,
                UserPromotion.stubUserPromotion,
                UserPromotion.stubUserPromotion
            ),
            avatarUrl = "https://cdn.dribbble.com/users/310943/avatars/normal/63403a089cd09d40cd08f3906bc50ff7.png?1648702627"
        )
    }
}

data class UserPromotion(
    val promotionId: Long,
    val text: String,
    val discountPercent: Int,
    val imageUrl: String?
) {
    companion object {
        val stubUserPromotion = UserPromotion(
            promotionId = 1,
            text = "Для вас сегодня скидка на самовывоз",
            discountPercent = 10,
            imageUrl = "https://www.sushieasy.ru/assets/images/cache/docs/24417/roll_filadelfiya_sfs.png/1655973419/320.png"
        )
    }
}
