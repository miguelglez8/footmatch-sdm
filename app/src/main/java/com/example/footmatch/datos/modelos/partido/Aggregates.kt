package com.example.footmatch.datos.modelos.partido


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Aggregates(
    @SerializedName("awayTeam")
    val awayTeam: AwayTeamXX,
    @SerializedName("homeTeam")
    val homeTeam: HomeTeamXX,
    @SerializedName("numberOfMatches")
    val numberOfMatches: Int,
    @SerializedName("totalGoals")
    val totalGoals: Int
) : Serializable