package com.example.footmatch.datos.modelos.partido


import com.google.gson.annotations.SerializedName

data class FullTime(
    @SerializedName("away")
    val away: Int,
    @SerializedName("home")
    val home: Int
)