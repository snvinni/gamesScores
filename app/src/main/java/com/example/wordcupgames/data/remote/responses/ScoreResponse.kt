package com.example.wordcupgames.data.remote.responses

import com.example.wordcupgames.model.Score
import com.google.gson.annotations.SerializedName


data class ScoreResponse(
    @SerializedName("winner")
    val winner: String?,
    @SerializedName("duration")
    val duration: String,
    @SerializedName("fullTime")
    val fullTime: TeamScoreResponse,
    @SerializedName("penalties")
    val penalties: TeamScoreResponse?
)

fun ScoreResponse.toModel() = Score(
    winner,
    duration,
    fullTime.toModel(),
    penalties?.toModel()
)