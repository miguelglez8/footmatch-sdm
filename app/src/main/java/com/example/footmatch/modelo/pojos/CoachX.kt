package com.example.footmatch.modelo.pojos


import com.google.gson.annotations.SerializedName

data class CoachX(
    @SerializedName("contract")
    val contract: Contract,
    @SerializedName("dateOfBirth")
    val dateOfBirth: String,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("nationality")
    val nationality: String
)