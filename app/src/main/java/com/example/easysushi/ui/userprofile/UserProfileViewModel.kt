package com.example.easysushi.ui.userprofile

import androidx.annotation.StringRes
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.easysushi.R
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserProfileViewModel @Inject constructor(): ViewModel() {

    private val _userName = mutableStateOf("TEST USER NAME")
    val userName = _userName

    private val _bonusProgramStatus = mutableStateOf(BonusProgramUserStatus.PRO)
    val bonusProgramStatus = _bonusProgramStatus

    private val _ordersQuantity = mutableStateOf(20)
    val ordersQuantity = _ordersQuantity

    private val _userPhoneNumber = mutableStateOf("+7 (999) 888-88-88")
    val userPhoneNumber = _userPhoneNumber

    // Пока данные захардкодил
    // TODO В будущем нужно будет сделать конвертер номера телефона в формат +7 (***) ***-**-**
}

enum class BonusProgramUserStatus(val discountPercentage: Int, @StringRes val statusTitle: Int) {
    NONE(discountPercentage = 0, statusTitle = R.string.bonus_program_status_title_none),
    START(discountPercentage = 5, statusTitle = R.string.bonus_program_status_title_start),
    MEDIUM(discountPercentage = 10, statusTitle = R.string.bonus_program_status_title_medium),
    PRO(discountPercentage = 20, statusTitle = R.string.bonus_program_status_title_pro)
    // TODO Прогрумить бонусную программу, пока первый набросок
}