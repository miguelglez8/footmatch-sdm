package com.example.footmatch.datos.modelos.partido


import com.google.gson.annotations.SerializedName
import java.io.Serializable

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
) : Serializable