package com.example.footmatch.datos.modelo.pojos.partido


import com.google.gson.annotations.SerializedName

data class Stats(
    @SerializedName("aggregates")
    val aggregates: com.example.footmatch.datos.modelo.pojos.partido.Aggregates,
    @SerializedName("filters")
    val filters: com.example.footmatch.datos.modelo.pojos.partido.FiltersX,
    @SerializedName("matches")
    val matches: List<com.example.footmatch.datos.modelo.pojos.partido.Matche>,
    @SerializedName("resultSet")
    val resultSet: com.example.footmatch.datos.modelo.pojos.partido.ResultSetX
)