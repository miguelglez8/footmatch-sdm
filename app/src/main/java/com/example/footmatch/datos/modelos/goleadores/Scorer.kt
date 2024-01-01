package com.example.footmatch.datos.modelos.goleadores


import com.google.gson.annotations.SerializedName

data class Scorer(
    @SerializedName("assists")
    val assists: Int,
    @SerializedName("goals")
    val goals: Int,
    @SerializedName("playedMatches")
    val playedMatches: Int,
    @SerializedName("penalties")
    val penalties: Int,
    @SerializedName("player")
    val player: Player,
    @SerializedName("team")
    val team: Team
)