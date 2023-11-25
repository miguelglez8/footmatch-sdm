package com.example.footmatch.modelo.pojos.partido


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Penalty(
    @SerializedName("player")
    val player: Player,
    @SerializedName("team")
    val team: Team,
    @SerializedName("scored")
    val scored: Boolean,
) : Serializable