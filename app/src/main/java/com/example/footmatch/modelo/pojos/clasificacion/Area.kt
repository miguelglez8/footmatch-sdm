package com.example.footmatch.modelo.pojos.clasificacion


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Area(
    @SerializedName("code")
    val code: String,
    @SerializedName("flag")
    val flag: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
) : Serializable