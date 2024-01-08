package com.example.footmatch.datos.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "half_times")
data class HalfTimeEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @SerializedName("away")
    val away: Int,
    @SerializedName("home")
    val home: Int
)
