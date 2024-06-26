package com.example.footmatch.datos.modelos.partido


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Squad(
    @SerializedName("dateOfBirth")
    val dateOfBirth: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("nationality")
    val nationality: String,
    @SerializedName("position")
    val position: String
) : Serializable