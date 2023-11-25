package com.example.footmatch.modelo.pojos.partido


import com.google.gson.annotations.SerializedName

data class SeasonX(
    @SerializedName("currentMatchday")
    val currentMatchday: Int,
    @SerializedName("endDate")
    val endDate: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("stages")
    val stages: List<String>,
    @SerializedName("startDate")
    val startDate: String,
    @SerializedName("winner")
    val winner: Any
)