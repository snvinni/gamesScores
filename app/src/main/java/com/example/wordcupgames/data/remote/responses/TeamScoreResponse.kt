package com.example.wordcupgames.data.remote.responses

import com.example.wordcupgames.model.TeamScore
import com.google.gson.annotations.SerializedName


data class TeamScoreResponse(
    @SerializedName("homeTeam")
    val homeTeam: Int,
    @SerializedName("awayTeam")
    val awayTeam: Int
)

fun TeamScoreResponse.toModel() = TeamScore(
    homeTeam,
    awayTeam,
)