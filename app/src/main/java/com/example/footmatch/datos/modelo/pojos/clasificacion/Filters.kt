package com.example.footmatch.datos.modelo.pojos.clasificacion


import com.google.gson.annotations.SerializedName

data class Filters(
    @SerializedName("season")
    val season: String
)