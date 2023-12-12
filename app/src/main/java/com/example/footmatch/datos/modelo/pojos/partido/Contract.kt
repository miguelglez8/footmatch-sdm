package com.example.footmatch.datos.modelo.pojos.partido


import com.google.gson.annotations.SerializedName

data class Contract(
    @SerializedName("start")
    val start: String,
    @SerializedName("until")
    val until: String
)