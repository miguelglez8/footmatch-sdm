package com.example.footmatch.modelo.pojos


import com.google.gson.annotations.SerializedName

data class MatchesBetweenDatesResult(
    @SerializedName("filters")
    val filters: Filters,
    @SerializedName("matches")
    val matches: List<Match>,
    @SerializedName("resultSet")
    val resultSet: ResultSet
)