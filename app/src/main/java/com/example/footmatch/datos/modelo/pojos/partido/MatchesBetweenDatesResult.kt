package com.example.footmatch.datos.modelo.pojos.partido


import com.google.gson.annotations.SerializedName

data class MatchesBetweenDatesResult(
    @SerializedName("filters")
    val filters: com.example.footmatch.datos.modelo.pojos.partido.Filters,
    @SerializedName("matches")
    val matches: List<com.example.footmatch.datos.modelo.pojos.partido.Match>,
    @SerializedName("resultSet")
    val resultSet: com.example.footmatch.datos.modelo.pojos.partido.ResultSet
)