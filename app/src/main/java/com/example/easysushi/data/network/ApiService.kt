package com.example.easysushi.data.network

import retrofit2.http.GET

interface ApiService {

    @GET("")
    suspend fun getAnything()
}