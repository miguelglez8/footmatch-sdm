package com.example.footmatch.datos.modelos.partido


import com.google.gson.annotations.SerializedName

data class Contract(
    @SerializedName("start")
    val start: String,
    @SerializedName("until")
    val until: String
)