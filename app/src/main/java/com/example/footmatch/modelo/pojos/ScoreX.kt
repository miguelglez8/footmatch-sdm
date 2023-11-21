package com.example.footmatch.modelo.pojos


import com.google.gson.annotations.SerializedName

data class ScoreX(
    @SerializedName("away")
    val away: Int,
    @SerializedName("home")
    val home: Int
)