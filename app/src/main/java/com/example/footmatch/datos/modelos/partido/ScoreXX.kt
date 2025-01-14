package com.example.footmatch.datos.modelos.partido


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ScoreXX(
    @SerializedName("duration")
    val duration: String,
    @SerializedName("fullTime")
    val fullTime: FullTime,
    @SerializedName("halfTime")
    val halfTime: HalfTime,
    @SerializedName("winner")
    val winner: String
) : Serializable