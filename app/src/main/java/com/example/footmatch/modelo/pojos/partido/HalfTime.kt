package com.example.footmatch.modelo.pojos.partido


import com.google.gson.annotations.SerializedName

data class HalfTime(
    @SerializedName("away")
    val away: Int,
    @SerializedName("home")
    val home: Int
)