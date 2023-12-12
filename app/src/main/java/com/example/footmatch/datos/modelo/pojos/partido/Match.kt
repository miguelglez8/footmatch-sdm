package com.example.footmatch.datos.modelo.pojos.partido


import com.google.gson.annotations.SerializedName

data class Match(
    @SerializedName("area")
    val area: com.example.footmatch.datos.modelo.pojos.partido.Area,
    @SerializedName("awayTeam")
    val awayTeam: com.example.footmatch.datos.modelo.pojos.partido.AwayTeam,
    @SerializedName("competition")
    val competition: com.example.footmatch.datos.modelo.pojos.partido.Competition,
    @SerializedName("group")
    val group: Any,
    @SerializedName("homeTeam")
    val homeTeam: com.example.footmatch.datos.modelo.pojos.partido.HomeTeam,
    @SerializedName("id")
    val id: Int,
    @SerializedName("lastUpdated")
    val lastUpdated: String,
    @SerializedName("matchday")
    val matchday: Int,
    @SerializedName("odds")
    val odds: com.example.footmatch.datos.modelo.pojos.partido.Odds,
    @SerializedName("referees")
    val referees: List<Any>,
    @SerializedName("score")
    val score: com.example.footmatch.datos.modelo.pojos.partido.Score,
    @SerializedName("season")
    val season: com.example.footmatch.datos.modelo.pojos.partido.Season,
    @SerializedName("stage")
    val stage: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("utcDate")
    val utcDate: String
)