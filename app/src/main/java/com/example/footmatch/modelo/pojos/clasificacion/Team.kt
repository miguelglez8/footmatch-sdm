package com.example.footmatch.modelo.pojos.clasificacion


import com.google.gson.annotations.SerializedName

data class Team(
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