package com.example.footmatch.datos.database

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "scores")
data class ScoreEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @SerializedName("duration")
    val duration: String,
    @Embedded(prefix="full_time_")
    val fullTime: FullTimeEntity,
    @Embedded(prefix="half_time_")
    val halfTime: HalfTimeEntity,
    @SerializedName("winner")
    val winner: String
)
