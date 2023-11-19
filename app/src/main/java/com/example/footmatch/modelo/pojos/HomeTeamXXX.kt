package com.example.footmatch.modelo.pojos


import com.google.gson.annotations.SerializedName

data class HomeTeamXXX(
    @SerializedName("bench")
    val bench: List<Any>,
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
    val lineup: List<Any>,
    @SerializedName("name")
    val name: String,
    @SerializedName("shortName")
    val shortName: String,
    @SerializedName("tla")
    val tla: String
)