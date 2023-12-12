package com.example.footmatch.datos.modelo.pojos.partido


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Aggregates(
    @SerializedName("awayTeam")
    val awayTeam: com.example.footmatch.datos.modelo.pojos.partido.AwayTeamXX,
    @SerializedName("homeTeam")
    val homeTeam: com.example.footmatch.datos.modelo.pojos.partido.HomeTeamXX,
    @SerializedName("numberOfMatches")
    val numberOfMatches: Int,
    @SerializedName("totalGoals")
    val totalGoals: Int
) : Serializable