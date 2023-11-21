package com.example.footmatch.modelo.pojos
import android.support.annotation.Nullable
import com.google.gson.annotations.SerializedName
import org.jetbrains.annotations.NotNull
import java.io.Serializable

data class MatchToShow(
    @SerializedName("area")
    val area: Area,
    @SerializedName("aggregates")
    var aggregates: Aggregates,
    @SerializedName("attendance")
    val attendance: Int,
    @SerializedName("awayTeam")
    val awayTeam: AwayTeamX,
    @SerializedName("bookings")
    val bookings: List<Booking> = mutableListOf(),
    @SerializedName("competition")
    val competition: Competition,
    @SerializedName("goals")
    val goals: List<Goal> = mutableListOf(),
    @SerializedName("group")
    val group: String,
    @SerializedName("homeTeam")
    val homeTeam: HomeTeamX,
    @SerializedName("id")
    //@PrimaryKey
    //@NotNull
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
    val penalties: List<Penalty> = mutableListOf(),
    @SerializedName("referees")
    val referees: List<Referee> = mutableListOf(),
    @SerializedName("score")
    val score: ScoreXX,
    @SerializedName("season")
    val season: SeasonX,
    @SerializedName("stage")
    val stage: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("substitutions")
    val substitutions: List<Substitution> = mutableListOf(),
    @SerializedName("utcDate")
    val utcDate: String,
    @SerializedName("venue")
    val venue: String
) : Serializable