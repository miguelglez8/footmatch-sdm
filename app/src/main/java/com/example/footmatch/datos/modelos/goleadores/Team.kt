package com.example.footmatch.datos.modelos.goleadores


import com.google.gson.annotations.SerializedName

data class Team(
    @SerializedName("address")
    val address: String,
    @SerializedName("clubColors")
    val clubColors: String,
    @SerializedName("crest")
    val crest: String,
    @SerializedName("founded")
    val founded: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("lastUpdated")
    val lastUpdated: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("shortName")
    val shortName: String,
    @SerializedName("tla")
    val tla: String,
    @SerializedName("venue")
    val venue: String,
    @SerializedName("website")
    val website: String
)