package com.example.footmatch.modelo.pojos.plantilla


import com.google.gson.annotations.SerializedName

data class SquadResult(
    @SerializedName("address")
    val address: String,
    @SerializedName("area")
    val area: Area,
    @SerializedName("clubColors")
    val clubColors: String,
    @SerializedName("coach")
    val coach: Coach,
    @SerializedName("crest")
    val crest: String,
    @SerializedName("founded")
    val founded: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("lastUpdated")
    val lastUpdated: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("runningCompetitions")
    val runningCompetitions: List<RunningCompetition>,
    @SerializedName("shortName")
    val shortName: String,
    @SerializedName("squad")
    val squad: List<Squad>,
    @SerializedName("staff")
    val staff: List<Any>,
    @SerializedName("tla")
    val tla: String,
    @SerializedName("venue")
    val venue: String,
    @SerializedName("website")
    val website: String
)