package com.example.footmatch.modelo.pojos.partido


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class AwayTeamX(
    @SerializedName("bench")
    val bench: List<Bench>,
    @SerializedName("coach")
    val coach: Coach,
    @SerializedName("crest")
    val crest: String,
    @SerializedName("formation")
    val formation: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("leagueRank")
    val leagueRank: Any,
    @SerializedName("lineup")
    val lineup: List<Lineup> = mutableListOf(),
    @SerializedName("name")
    val name: String,
    @SerializedName("shortName")
    val shortName: String,
    @SerializedName("statistics")
    val statistics: Statistics,
    @SerializedName("tla")
    val tla: String,
    var trainer: String
) : Serializable