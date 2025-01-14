package com.example.footmatch.datos.modelos.partido


import com.google.gson.annotations.SerializedName

data class Score(
    @SerializedName("duration")
    val duration: String,
    @SerializedName("fullTime")
    val fullTime: FullTime,
    @SerializedName("halfTime")
    val halfTime: HalfTime,
    @SerializedName("winner")
    val winner: String
)