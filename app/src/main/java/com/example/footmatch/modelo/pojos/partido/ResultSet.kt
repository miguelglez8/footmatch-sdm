package com.example.footmatch.modelo.pojos.partido


import com.google.gson.annotations.SerializedName

data class ResultSet(
    @SerializedName("competitions")
    val competitions: String,
    @SerializedName("count")
    val count: Int,
    @SerializedName("first")
    val first: String,
    @SerializedName("last")
    val last: String,
    @SerializedName("played")
    val played: Int
)