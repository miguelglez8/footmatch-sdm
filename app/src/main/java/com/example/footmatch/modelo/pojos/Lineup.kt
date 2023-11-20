package com.example.footmatch.modelo.pojos


import com.google.gson.annotations.SerializedName

data class Lineup(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("position")
    val position: String,
    @SerializedName("shirtNumber")
    val shirtNumber: Int
)