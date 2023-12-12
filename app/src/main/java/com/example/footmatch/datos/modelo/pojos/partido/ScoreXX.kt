package com.example.footmatch.datos.modelo.pojos.partido


import com.google.gson.annotations.SerializedName

data class ScoreXX(
    @SerializedName("duration")
    val duration: String,
    @SerializedName("fullTime")
    val fullTime: com.example.footmatch.datos.modelo.pojos.partido.FullTime,
    @SerializedName("halfTime")
    val halfTime: com.example.footmatch.datos.modelo.pojos.partido.HalfTime,
    @SerializedName("winner")
    val winner: String
)