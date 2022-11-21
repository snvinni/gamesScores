package com.example.wordcupgames.data.services

import com.example.wordcupgames.data.remote.responses.MatchWrapperResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MatchService {

    @GET("v2/matches")
    suspend fun getMatches(
        @Query("dateFrom") dateFrom: String,
        @Query("dateTo") dateTo: String,
        @Query("competition") competition: String,
    ): Response<MatchWrapperResponse>

}