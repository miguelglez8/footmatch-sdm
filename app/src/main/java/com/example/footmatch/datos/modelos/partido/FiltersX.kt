package com.example.footmatch.datos.modelos.partido


import com.google.gson.annotations.SerializedName

data class FiltersX(
    @SerializedName("limit")
    val limit: String,
    @SerializedName("permission")
    val permission: String
)