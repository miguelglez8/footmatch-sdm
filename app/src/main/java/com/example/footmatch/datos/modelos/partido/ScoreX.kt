package com.example.footmatch.datos.modelos.partido


import com.google.gson.annotations.SerializedName

data class ScoreX(
    @SerializedName("away")
    val away: Int,
    @SerializedName("home")
    val home: Int
)