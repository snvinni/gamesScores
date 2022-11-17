package com.example.wordcupgames.data.remote.responses

import com.google.gson.annotations.SerializedName

data class MatchResponse (
    @SerializedName("count")
    val count: Int,
    @SerializedName("filters")
    val filters: Filters,
    @SerializedName("matches")
    val matches: List<Match>,
) {
    data class Filters(
        @SerializedName("dateFrom")
        val dateFrom: String,
        @SerializedName("dateTo")
        val dateTo: String,
        @SerializedName("permission")
        val permission: String,
    )

    data class Match(
        @SerializedName("id")
        val id: Int,
        @SerializedName("area")
        val area: Area,
        @SerializedName("competition")
        val competition: CompetitionResponse,
        @SerializedName("season")
        val season: Season,
        @SerializedName("utcDate")
        val utcDate: String,
        @SerializedName("status")
        val status: String,
        @SerializedName("venue")
        val stadium: String,
        @SerializedName("matchday")
        val matchDay: Int,
        @SerializedName("stage")
        val competitionStage: String,
        @SerializedName("group")
        val competitionGroup: String,
        @SerializedName("lastUpdated")
        val lastUpdated: String,
        @SerializedName("homeTeam")
        val homeTeam: TeamResponse,
        @SerializedName("awayTeam")
        val awayTeam: TeamResponse,
        )

    data class Area(
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String,
    )

    data class Season(
        @SerializedName("id")
        val id: Int,
        @SerializedName("startDate")
        val startDate: String,
        @SerializedName("endDate")
        val endDate: String,
        @SerializedName("currentMatchday")
        val currentMatchDay: Int,
        @SerializedName("winner")
        val winner: String
    )

    data class Score(
        @SerializedName("winner")
        val winner: String,
        @SerializedName("duration")
        val duration: String,
        @SerializedName("fullTime")
        val fullTime: TeamScore,
        @SerializedName("penalties")
        val penalties: TeamScore
    )

    data class TeamScore(
        @SerializedName("homeTeam")
        val homeTeam: Int,
        @SerializedName("awayTeam")
        val awayTeam: Int
    )
}

