package com.example.footmatch.modelo.pojos.plantilla


import com.google.gson.annotations.SerializedName

data class Contract(
    @SerializedName("start")
    val start: String,
    @SerializedName("until")
    val until: String
)