package com.example.wordcupgames.model

data class Matches(
    val id: Int,
    val area: Area,
    val competition: Competition,
    val season: Season,
    val utcDate: String,
    val status: String,
    val stadium: String,
    val matchDay: Int,
    val competitionStage: String,
    val competitionGroup: String,
    val lastUpdated: String,
    val score: Score,
    val homeTeam: Team,
    val awayTeam: Team,
) : Comparable<Matches> {
    override fun compareTo(other: Matches): Int {
        if (other.id < 0) return 1

        return if (id < 0) -1 else other.id.compareTo(id)
    }
}