package com.example.footmatch.datos.modelos.goleadores


import com.google.gson.annotations.SerializedName

data class Season(
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