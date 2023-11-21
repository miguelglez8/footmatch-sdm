package com.example.footmatch.modelo.pojos.plantilla


import com.google.gson.annotations.SerializedName

data class Squad(
    @SerializedName("dateOfBirth")
    val dateOfBirth: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("nationality")
    val nationality: String,
    @SerializedName("position")
    val position: String
)