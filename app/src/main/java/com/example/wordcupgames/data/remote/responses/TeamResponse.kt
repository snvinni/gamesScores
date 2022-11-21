package com.example.wordcupgames.data.remote.responses

import com.example.wordcupgames.model.Team
import com.google.gson.annotations.SerializedName

data class TeamResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("shortName")
    val shortName: String?,
    @SerializedName("tla")
    val initials: String?,
    @SerializedName("crestUrl")
    val crestUrl: String?,
    @SerializedName("clubColors")
    val clubColors: String?,
    @SerializedName("venue")
    val venue: String?
)
fun TeamResponse.toModel() = Team(
    id,
    name,
    shortName,
    initials,
    crestUrl,
    clubColors,
    venue
)