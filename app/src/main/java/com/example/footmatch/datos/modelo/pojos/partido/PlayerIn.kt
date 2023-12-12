package com.example.footmatch.datos.modelo.pojos.partido


import com.google.gson.annotations.SerializedName

data class PlayerIn(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)