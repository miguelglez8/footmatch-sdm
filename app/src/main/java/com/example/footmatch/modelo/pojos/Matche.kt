package com.example.footmatch.modelo.pojos


import com.google.gson.annotations.SerializedName

data class Matche(
    @SerializedName("area")
    val area: Area,
    @SerializedName("attendance")
    val attendance: Int,
    @SerializedName("awayTeam")
    val awayTeam: AwayTeamXXX,
    @SerializedName("bookings")
    val bookings: List<Any>,
    @SerializedName("competition")
    val competition: Competition,
    @SerializedName("goals")
    val goals: List<Any>,
    @SerializedName("group")
    val group: String,
    @SerializedName("homeTeam")
    val homeTeam: HomeTeamXXX,
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
    val odds: OddsX,
    @SerializedName("penalties")
    val penalties: List<Any>,
    @SerializedName("referees")
    val referees: List<Referee>,
    @SerializedName("score")
    val score: ScoreXX,
    @SerializedName("season")
    val season: SeasonX,
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