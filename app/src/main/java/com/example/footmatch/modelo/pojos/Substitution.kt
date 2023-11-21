package com.example.footmatch.modelo.pojos


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Substitution(
    @SerializedName("minute")
    val minute: Int,
    @SerializedName("playerIn")
    val playerIn: PlayerIn,
    @SerializedName("playerOut")
    val playerOut: PlayerOut,
    @SerializedName("team")
    val team: Team
) : Serializable