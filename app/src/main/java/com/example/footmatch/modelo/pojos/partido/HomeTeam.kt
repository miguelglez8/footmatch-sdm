package com.example.footmatch.modelo.pojos.partido


import com.google.gson.annotations.SerializedName

data class HomeTeam(
    @SerializedName("crest")
    val crest: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("shortName")
    val shortName: String,
    @SerializedName("tla")
    val tla: String
)