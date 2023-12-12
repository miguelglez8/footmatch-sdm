package com.example.footmatch.datos.modelo.pojos.clasificacion


import com.google.gson.annotations.SerializedName

data class StandingsResult(
    @SerializedName("area")
    val area: com.example.footmatch.datos.modelo.pojos.clasificacion.Area,
    @SerializedName("competition")
    val competition: com.example.footmatch.datos.modelo.pojos.clasificacion.Competition,
    @SerializedName("filters")
    val filters: com.example.footmatch.datos.modelo.pojos.clasificacion.Filters,
    @SerializedName("season")
    val season: com.example.footmatch.datos.modelo.pojos.clasificacion.Season,
    @SerializedName("standings")
    val standings: List<com.example.footmatch.datos.modelo.pojos.clasificacion.Standing>
)