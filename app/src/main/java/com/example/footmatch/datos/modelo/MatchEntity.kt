package com.example.footmatch.datos.modelo

import androidx.annotation.Nullable
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.example.footmatch.datos.modelo.pojos.partido.Area
import com.example.footmatch.datos.modelo.pojos.partido.AwayTeam
import com.example.footmatch.datos.modelo.pojos.partido.Competition
import com.example.footmatch.datos.modelo.pojos.partido.HomeTeam
import com.example.footmatch.datos.modelo.pojos.partido.Odds
import com.example.footmatch.datos.modelo.pojos.partido.Score
import com.example.footmatch.datos.modelo.pojos.partido.Season

@Entity(tableName = "matches")
data class MatchEntity (
    @Embedded
    val area: Area,

    @ColumnInfo(name = "away_team")
    @Embedded
    val awayTeam: AwayTeam,

    @Embedded
    val competition: Competition,

    val group: Any,
    @ColumnInfo(name = "home_team")
    @Embedded
    val homeTeam: HomeTeam,

    @PrimaryKey(autoGenerate = false)
    val id: Int,

    @ColumnInfo(name = "last_updated")
    val lastUpdated: String,
    @ColumnInfo(name = "match_day")
    val matchday: Int,

    @Embedded
    val odds: Odds,

    @Ignore
    val referees: List<Any>,

    @Embedded
    val score: Score?,
    @Embedded
    val season: Season,

    val stage: String,

    val status: String,
    @ColumnInfo(name = "utc_date")
    val utcDate: String,
)