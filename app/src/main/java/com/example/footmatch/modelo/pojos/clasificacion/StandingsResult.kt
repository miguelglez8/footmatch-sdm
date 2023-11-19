package com.example.footmatch.modelo.pojos.clasificacion


import com.google.gson.annotations.SerializedName

data class StandingsResult(
    @SerializedName("area")
    val area: Area,
    @SerializedName("competition")
    val competition: Competition,
    @SerializedName("filters")
    val filters: Filters,
    @SerializedName("season")
    val season: Season,
    @SerializedName("standings")
    val standings: List<Standing>
)