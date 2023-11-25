package com.example.footmatch.modelo.pojos.partido


import com.google.gson.annotations.SerializedName

data class OddsX(
    @SerializedName("awayWin")
    val awayWin: Double,
    @SerializedName("draw")
    val draw: Double,
    @SerializedName("homeWin")
    val homeWin: Double
)