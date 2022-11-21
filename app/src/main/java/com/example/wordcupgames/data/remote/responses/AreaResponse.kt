package com.example.wordcupgames.data.remote.responses

import com.example.wordcupgames.model.Area
import com.google.gson.annotations.SerializedName

data class AreaResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
)
fun AreaResponse.toModel() = Area(
    id,
    name
)