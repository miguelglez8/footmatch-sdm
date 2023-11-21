package com.example.footmatch.modelo.pojos


import com.google.gson.annotations.SerializedName

data class AwayTeamXX(
    @SerializedName("draws")
    val draws: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("losses")
    val losses: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("wins")
    val wins: Int
)