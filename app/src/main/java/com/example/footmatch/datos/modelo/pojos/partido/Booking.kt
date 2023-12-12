package com.example.footmatch.datos.modelo.pojos.partido


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Booking(
    @SerializedName("card")
    val card: String,
    @SerializedName("minute")
    val minute: Int,
    @SerializedName("player")
    val player: com.example.footmatch.datos.modelo.pojos.partido.Player,
    @SerializedName("team")
    val team: com.example.footmatch.datos.modelo.pojos.partido.Team
) : Serializable