package com.example.easysushi.domain.repository

import com.example.easysushi.domain.model.User

interface UserRepository {
    fun getUserById(userId: Long): User
}
