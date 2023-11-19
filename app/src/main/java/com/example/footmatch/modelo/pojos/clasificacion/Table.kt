package com.example.footmatch.modelo.pojos.clasificacion


import com.google.gson.annotations.SerializedName

data class Table(
    @SerializedName("draw")
    val draw: Int,
    @SerializedName("form")
    val form: Any,
    @SerializedName("goalDifference")
    val goalDifference: Int,
    @SerializedName("goalsAgainst")
    val goalsAgainst: Int,
    @SerializedName("goalsFor")
    val goalsFor: Int,
    @SerializedName("lost")
    val lost: Int,
    @SerializedName("playedGames")
    val playedGames: Int,
    @SerializedName("points")
    val points: Int,
    @SerializedName("position")
    val position: Int,
    @SerializedName("team")
    val team: Team,
    @SerializedName("won")
    val won: Int
)