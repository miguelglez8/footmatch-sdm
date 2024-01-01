package com.example.footmatch.datos.modelos.clasificacion


import com.google.gson.annotations.SerializedName

data class Filters(
    @SerializedName("season")
    val season: String
)