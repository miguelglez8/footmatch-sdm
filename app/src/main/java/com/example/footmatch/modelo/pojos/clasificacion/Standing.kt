package com.example.footmatch.modelo.pojos.clasificacion


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Standing(
    @SerializedName("group")
    val group: Any,
    @SerializedName("stage")
    val stage: String,
    @SerializedName("table")
    val table: List<Table>,
    @SerializedName("type")
    val type: String
) : Serializable