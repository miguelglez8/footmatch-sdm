package com.example.footmatch.datos.modelos.goleadores


import com.google.gson.annotations.SerializedName

data class Scorers(
    @SerializedName("competition")
    val competition: Competition,
    @SerializedName("count")
    val count: Int,
    @SerializedName("filters")
    val filters: Filters,
    @SerializedName("scorers")
    val scorers: List<Scorer>,
    @SerializedName("season")
    val season: Season
)