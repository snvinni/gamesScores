package com.example.wordcupgames.model

data class Season(
    val id: Int,
    val startDate: String,
    val endDate: String,
    val currentMatchDay: Int,
    val winner: String?
)
