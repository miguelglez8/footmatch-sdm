package com.example.footmatch.datos.modelos.partido


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class AwayTeam(
    @SerializedName("crest")
    val crest: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("shortName")
    val shortName: String,
    @SerializedName("tla")
    val tla: String
): Serializable