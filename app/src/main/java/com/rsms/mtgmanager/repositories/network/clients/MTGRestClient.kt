package com.rsms.mtgmanager.repositories.network.clients

import com.rsms.mtgmanager.repositories.network.dtos.CardDTO
import com.rsms.mtgmanager.repositories.network.dtos.CardListDTO
import com.rsms.mtgmanager.repositories.network.dtos.SetDTO
import com.rsms.mtgmanager.repositories.network.dtos.SetListDTO
import retrofit2.http.GET
import retrofit2.http.Headers

interface MTGRestClient {

    @GET("sets")
    @Headers("Content-Type: application/json")
    suspend fun setsAsync(): SetListDTO

    @GET("cards")
    @Headers("Content-Type: application/json")
    suspend fun cardsAsync(): CardListDTO
}