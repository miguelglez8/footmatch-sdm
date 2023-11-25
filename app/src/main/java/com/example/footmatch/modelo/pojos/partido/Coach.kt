package com.example.footmatch.modelo.pojos.partido


import com.google.gson.annotations.SerializedName

data class Coach(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("nationality")
    val nationality: String
)