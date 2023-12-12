package com.example.footmatch.datos.modelo.pojos.partido
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MatchToShow(
    @SerializedName("area")
    val area: com.example.footmatch.datos.modelo.pojos.partido.Area,
    @SerializedName("aggregates")
    var aggregates: com.example.footmatch.datos.modelo.pojos.partido.Aggregates,
    @SerializedName("attendance")
    val attendance: Int,
    @SerializedName("awayTeam")
    val awayTeam: com.example.footmatch.datos.modelo.pojos.partido.AwayTeamX,
    @SerializedName("bookings")
    val bookings: List<com.example.footmatch.datos.modelo.pojos.partido.Booking> = mutableListOf(),
    @SerializedName("competition")
    val competition: com.example.footmatch.datos.modelo.pojos.partido.Competition,
    @SerializedName("goals")
    val goals: List<com.example.footmatch.datos.modelo.pojos.partido.Goal> = mutableListOf(),
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
    val penalties: List<com.example.footmatch.datos.modelo.pojos.partido.Penalty> = mutableListOf(),
    @SerializedName("referees")
    val referees: List<com.example.footmatch.datos.modelo.pojos.partido.Referee> = mutableListOf(),
    @SerializedName("score")
    val score: com.example.footmatch.datos.modelo.pojos.partido.ScoreXX,
    @SerializedName("season")
    val season: com.example.footmatch.datos.modelo.pojos.partido.SeasonX,
    @SerializedName("stage")
    val stage: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("substitutions")
    val substitutions: List<com.example.footmatch.datos.modelo.pojos.partido.Substitution> = mutableListOf(),
    @SerializedName("utcDate")
    val utcDate: String,
    @SerializedName("venue")
    val venue: String
) : Serializable