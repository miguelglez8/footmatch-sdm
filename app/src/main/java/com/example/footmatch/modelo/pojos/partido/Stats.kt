package com.example.footmatch.modelo.pojos.partido


import com.google.gson.annotations.SerializedName

data class Stats(
    @SerializedName("aggregates")
    val aggregates: Aggregates,
    @SerializedName("filters")
    val filters: FiltersX,
    @SerializedName("matches")
    val matches: List<Matche>,
    @SerializedName("resultSet")
    val resultSet: ResultSetX
)