package com.example.wordcupgames.data.remote.responses

import com.example.wordcupgames.model.Competition
import com.google.gson.annotations.SerializedName

data class CompetitionResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("code")
    val code: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("emblem")
    val emblem: String,
)
fun CompetitionResponse.toModel() = Competition(
    id,
    name,
    code,
    type,
    emblem
)