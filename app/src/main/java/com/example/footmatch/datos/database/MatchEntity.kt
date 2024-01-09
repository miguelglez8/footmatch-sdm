package com.example.footmatch.datos.database

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.footmatch.datos.modelos.partido.AwayTeam
import com.example.footmatch.datos.modelos.partido.HomeTeam

@Entity(tableName = "matches")
data class MatchEntity (

    @Embedded(prefix="away_")
    val awayTeam: AwayTeam,


    @Embedded(prefix="home_")
    val homeTeam: HomeTeam,

    @PrimaryKey(autoGenerate = false)
    val id: Int,

    val status: String,

    @Embedded(prefix="score_")
    val score: ScoreEntity,

    @ColumnInfo(name = "utc_date")
    val utcDate: String

    )