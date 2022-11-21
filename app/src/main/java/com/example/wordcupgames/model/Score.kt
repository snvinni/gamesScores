package com.example.wordcupgames.model

data class Score(
    val winner: String?,
    val duration: String,
    val fullTime: TeamScore,
    val penalties: TeamScore?
)