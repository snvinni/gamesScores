package com.example.wordcupgames.data.remote.responses

import com.google.gson.annotations.SerializedName

data class CompetitionTeamsResponse(
    @SerializedName("count")
    val count: Int,
    @SerializedName("competition")
    val competition: CompetitionResponse,
    @SerializedName("teams")
    val teams: List<TeamResponse>
)
