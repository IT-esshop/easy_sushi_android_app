package com.example.easysushi.ui.userprofile

import android.util.Log
import androidx.annotation.StringRes
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.easysushi.R
import com.example.easysushi.domain.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserProfileViewModel @Inject constructor(): ViewModel() {
    private val _user = mutableStateOf(User.stubUser)
    val user = _user

    fun activatePromo(promoId: Long) {
        Log.d("UserProfileViewModel", "activated promo with id $promoId")
    }
}

enum class BonusProgramUserStatus(val discountPercentage: Int, @StringRes val statusTitle: Int) {
    NONE(discountPercentage = 0, statusTitle = R.string.bonus_program_status_title_none),
    START(discountPercentage = 5, statusTitle = R.string.bonus_program_status_title_start),
    MEDIUM(discountPercentage = 10, statusTitle = R.string.bonus_program_status_title_medium),
    PRO(discountPercentage = 20, statusTitle = R.string.bonus_program_status_title_pro)
    // TODO Прогрумить бонусную программу, пока первый набросок
}