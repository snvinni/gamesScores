package com.example.wordcupgames.data.remote.responses

import com.example.wordcupgames.model.Season
import com.google.gson.annotations.SerializedName

data class SeasonResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("startDate")
    val startDate: String,
    @SerializedName("endDate")
    val endDate: String,
    @SerializedName("currentMatchday")
    val currentMatchDay: Int,
    @SerializedName("winner")
    val winner: String?
)
fun SeasonResponse.toModel() = Season(
    id,
    startDate,
    endDate,
    currentMatchDay,
    winner
)