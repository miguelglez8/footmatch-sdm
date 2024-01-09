package com.example.footmatch.datos.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "full_times")
data class FullTimeEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @SerializedName("away")
    val away: Int,
    @SerializedName("home")
    val home: Int
)
