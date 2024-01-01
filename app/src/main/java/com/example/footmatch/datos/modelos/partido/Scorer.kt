package com.example.footmatch.datos.modelos.partido


import com.google.gson.annotations.SerializedName

data class Scorer(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)