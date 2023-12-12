package com.example.footmatch.datos.modelo.pojos.partido


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class AwayTeamX(
    @SerializedName("bench")
    val bench: List<com.example.footmatch.datos.modelo.pojos.partido.Bench>,
    @SerializedName("coach")
    val coach: com.example.footmatch.datos.modelo.pojos.partido.Coach,
    @SerializedName("crest")
    val crest: String,
    @SerializedName("formation")
    val formation: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("leagueRank")
    val leagueRank: Any,
    @SerializedName("lineup")
    val lineup: List<com.example.footmatch.datos.modelo.pojos.partido.Lineup> = mutableListOf(),
    @SerializedName("name")
    val name: String,
    @SerializedName("shortName")
    val shortName: String,
    @SerializedName("statistics")
    val statistics: com.example.footmatch.datos.modelo.pojos.partido.Statistics,
    @SerializedName("tla")
    val tla: String,
    var trainer: String
) : Serializable