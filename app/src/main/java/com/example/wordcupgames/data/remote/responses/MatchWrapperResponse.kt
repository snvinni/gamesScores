package com.example.wordcupgames.data.remote.responses

import com.google.gson.annotations.SerializedName

data class MatchWrapperResponse(
    @SerializedName("matches")
    val matches: List<MatchResponse>
)