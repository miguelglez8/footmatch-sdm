package com.example.footmatch.datos.modelo.pojos.partido


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TeamX(
    @SerializedName("address")
    val address: String,
    @SerializedName("area")
    val area: com.example.footmatch.datos.modelo.pojos.partido.Area,
    @SerializedName("clubColors")
    val clubColors: String,
    @SerializedName("coach")
    val coach: com.example.footmatch.datos.modelo.pojos.partido.CoachX,
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
    val runningCompetitions: List<com.example.footmatch.datos.modelo.pojos.partido.RunningCompetition>,
    @SerializedName("shortName")
    val shortName: String,
    @SerializedName("squad")
    val squad: List<com.example.footmatch.datos.modelo.pojos.partido.Squad>,
    @SerializedName("staff")
    val staff: List<Any>,
    @SerializedName("tla")
    val tla: String,
    @SerializedName("venue")
    val venue: String,
    @SerializedName("website")
    val website: String
) : Serializable