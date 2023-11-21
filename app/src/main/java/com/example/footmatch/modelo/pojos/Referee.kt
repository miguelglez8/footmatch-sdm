package com.example.footmatch.modelo.pojos


import com.google.gson.annotations.SerializedName

data class Referee(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("nationality")
    val nationality: String,
    @SerializedName("type")
    val type: String
)