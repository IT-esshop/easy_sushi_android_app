package com.example.easysushi.data.remote

import com.example.easysushi.domain.model.Ware
import retrofit2.http.GET

interface EasySushiApi {

    @GET("END_POINT")
    suspend fun getAllWares(): List<Ware>
}
