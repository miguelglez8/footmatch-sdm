package com.example.footmatch.modelo.pojos.clasificacion


import com.google.gson.annotations.SerializedName

data class Filters(
    @SerializedName("season")
    val season: String
)