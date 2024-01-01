package com.example.footmatch.datos.modelos.partido


import com.google.gson.annotations.SerializedName

data class OddsX(
    @SerializedName("awayWin")
    val awayWin: Double,
    @SerializedName("draw")
    val draw: Double,
    @SerializedName("homeWin")
    val homeWin: Double
)