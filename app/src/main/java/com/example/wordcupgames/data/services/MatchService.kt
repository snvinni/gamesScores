package com.example.wordcupgames.data

import com.example.wordcupgames.data.remote.responses.CompetitionResponse
import com.example.wordcupgames.data.remote.responses.CompetitionTeamsResponse
import com.example.wordcupgames.data.remote.responses.MatchResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MatchService {

    @GET("v4/matches")
    suspend fun getMatches(
        @Query("dateFrom") dateFrom: String,
        @Query("dateTo") dateTo: String,
        @Query("status") status: String,
        @Query("competition") competition: String,
    ): MatchResponse

    @GET("v4/competitions/WC/matches")
    suspend fun getCompetitions(): CompetitionResponse

    @GET("v2/competitions/{id}/teams")
    suspend fun getTeamsByCompetition(@Path("id") competitionId: Int): CompetitionTeamsResponse
}