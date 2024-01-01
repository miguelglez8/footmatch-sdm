package com.example.footmatch.datos.modelos.partido


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Booking(
    @SerializedName("card")
    val card: String,
    @SerializedName("minute")
    val minute: Int,
    @SerializedName("player")
    val player: Player,
    @SerializedName("team")
    val team: Team
) : Serializable