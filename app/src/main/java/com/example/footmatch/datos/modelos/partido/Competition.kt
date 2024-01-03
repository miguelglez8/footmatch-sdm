package com.example.footmatch.datos.modelos.partido


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Competition(
    @SerializedName("code")
    val code: String,
    @SerializedName("emblem")
    val emblem: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    val type: String
) : Serializable