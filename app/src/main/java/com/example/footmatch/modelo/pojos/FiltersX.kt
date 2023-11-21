package com.example.footmatch.modelo.pojos


import com.google.gson.annotations.SerializedName

data class FiltersX(
    @SerializedName("limit")
    val limit: String,
    @SerializedName("permission")
    val permission: String
)