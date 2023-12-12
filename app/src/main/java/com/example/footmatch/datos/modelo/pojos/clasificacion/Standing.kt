package com.example.footmatch.datos.modelo.pojos.clasificacion


import com.google.gson.annotations.SerializedName

data class Standing(
    @SerializedName("group")
    val group: Any,
    @SerializedName("stage")
    val stage: String,
    @SerializedName("table")
    val table: List<com.example.footmatch.datos.modelo.pojos.clasificacion.Table>,
    @SerializedName("type")
    val type: String
)