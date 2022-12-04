package com.example.wordcupgames.data.remote.responses

import com.example.wordcupgames.model.Matches
import com.google.gson.annotations.SerializedName

data class MatchResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("area")
    val area: AreaResponse?,
    @SerializedName("competition")
    val competition: CompetitionResponse,
    @SerializedName("season")
    val season: SeasonResponse,
    @SerializedName("utcDate")
    val utcDate: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("venue")
    val stadium: String?,
    @SerializedName("matchday")
    val matchDay: Int,
    @SerializedName("stage")
    val competitionStage: String,
    @SerializedName("group")
    val competitionGroup: String?,
    @SerializedName("lastUpdated")
    val lastUpdated: String,
    @SerializedName("score")
    val score: ScoreResponse,
    @SerializedName("homeTeam")
    val homeTeam: TeamResponse,
    @SerializedName("awayTeam")
    val awayTeam: TeamResponse,
)

fun MatchResponse.toModel() = Matches(
    id,
    area?.toModel(),
    competition.toModel(),
    season.toModel(),
    utcDate,
    status,
    stadium,
    matchDay,
    competitionStage,
    competitionGroup,
    lastUpdated,
    score.toModel(),
    homeTeam.toModel(),
    awayTeam.toModel()
)