package com.example.footmatch.datos.modelo.pojos.partido


import com.google.gson.annotations.SerializedName

data class Matche(
    @SerializedName("area")
    val area: com.example.footmatch.datos.modelo.pojos.partido.Area,
    @SerializedName("attendance")
    val attendance: Int,
    @SerializedName("awayTeam")
    val awayTeam: com.example.footmatch.datos.modelo.pojos.partido.AwayTeamX,
    @SerializedName("bookings")
    val bookings: List<Any>,
    @SerializedName("competition")
    val competition: com.example.footmatch.datos.modelo.pojos.partido.Competition,
    @SerializedName("goals")
    val goals: List<Any>,
    @SerializedName("group")
    val group: String,
    @SerializedName("homeTeam")
    val homeTeam: com.example.footmatch.datos.modelo.pojos.partido.HomeTeamX,
    @SerializedName("id")
    val id: Int,
    @SerializedName("injuryTime")
    val injuryTime: Int,
    @SerializedName("lastUpdated")
    val lastUpdated: String,
    @SerializedName("matchday")
    val matchday: Int,
    @SerializedName("minute")
    val minute: Int,
    @SerializedName("odds")
    val odds: com.example.footmatch.datos.modelo.pojos.partido.OddsX,
    @SerializedName("penalties")
    val penalties: List<Any>,
    @SerializedName("referees")
    val referees: List<com.example.footmatch.datos.modelo.pojos.partido.Referee>,
    @SerializedName("score")
    val score: com.example.footmatch.datos.modelo.pojos.partido.ScoreXX,
    @SerializedName("season")
    val season: com.example.footmatch.datos.modelo.pojos.partido.SeasonX,
    @SerializedName("stage")
    val stage: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("substitutions")
    val substitutions: List<Any>,
    @SerializedName("utcDate")
    val utcDate: String,
    @SerializedName("venue")
    val venue: String
)