package com.example.footmatch.modelo.pojos


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MatchToShow(
    @SerializedName("area")
    val area: Area,
    @SerializedName("attendance")
    val attendance: Int,
    @SerializedName("awayTeam")
    val awayTeam: AwayTeamX,
    @SerializedName("bookings")
    val bookings: List<Booking>,
    @SerializedName("competition")
    val competition: Competition,
    @SerializedName("goals")
    val goals: List<Goal>,
    @SerializedName("group")
    val group: String,
    @SerializedName("homeTeam")
    val homeTeam: HomeTeamX,
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
    val penalties: List<Penalty>,
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
    val substitutions: List<Substitution>,
    @SerializedName("utcDate")
    val utcDate: String,
    @SerializedName("venue")
    val venue: String
) : Serializable