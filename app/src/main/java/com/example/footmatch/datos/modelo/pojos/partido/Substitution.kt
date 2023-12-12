package com.example.footmatch.datos.modelo.pojos.partido


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Substitution(
    @SerializedName("minute")
    val minute: Int,
    @SerializedName("playerIn")
    val playerIn: com.example.footmatch.datos.modelo.pojos.partido.PlayerIn,
    @SerializedName("playerOut")
    val playerOut: com.example.footmatch.datos.modelo.pojos.partido.PlayerOut,
    @SerializedName("team")
    val team: com.example.footmatch.datos.modelo.pojos.partido.Team
) : Serializable