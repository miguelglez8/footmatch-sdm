package com.example.footmatch.datos.modelos.partido


import com.google.gson.annotations.SerializedName
import java.io.Serializable

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
): Serializable