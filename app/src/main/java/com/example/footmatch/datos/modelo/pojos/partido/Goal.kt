package com.example.footmatch.datos.modelo.pojos.partido


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Goal(
    @SerializedName("assist")
    val assist: com.example.footmatch.datos.modelo.pojos.partido.Assist,
    @SerializedName("injuryTime")
    val injuryTime: Any,
    @SerializedName("minute")
    val minute: Int,
    @SerializedName("score")
    val score: com.example.footmatch.datos.modelo.pojos.partido.ScoreX,
    @SerializedName("scorer")
    val scorer: com.example.footmatch.datos.modelo.pojos.partido.Scorer,
    @SerializedName("team")
    val team: com.example.footmatch.datos.modelo.pojos.partido.Team,
    @SerializedName("type")
    val type: String
) : Serializable