package com.example.footmatch.modelo.pojos.goleadores


import com.google.gson.annotations.SerializedName

data class Filters(
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("season")
    val season: String
)