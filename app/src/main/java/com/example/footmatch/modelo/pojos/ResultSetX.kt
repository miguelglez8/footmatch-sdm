package com.example.footmatch.modelo.pojos


import com.google.gson.annotations.SerializedName

data class ResultSetX(
    @SerializedName("competitions")
    val competitions: String,
    @SerializedName("count")
    val count: Int,
    @SerializedName("first")
    val first: String,
    @SerializedName("last")
    val last: String
)