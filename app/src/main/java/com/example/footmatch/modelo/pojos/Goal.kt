package com.example.footmatch.modelo.pojos


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Goal(
    @SerializedName("assist")
    val assist: Assist,
    @SerializedName("injuryTime")
    val injuryTime: Any,
    @SerializedName("minute")
    val minute: Int,
    @SerializedName("score")
    val score: ScoreX,
    @SerializedName("scorer")
    val scorer: Scorer,
    @SerializedName("team")
    val team: Team,
    @SerializedName("type")
    val type: String
) : Serializable