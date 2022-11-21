package com.example.wordcupgames.model

data class Team(
val id: Int,
val name: String,
val shortName: String?,
val initials: String?,
val crestUrl: String?,
val clubColors: String?,
val venue: String?
)