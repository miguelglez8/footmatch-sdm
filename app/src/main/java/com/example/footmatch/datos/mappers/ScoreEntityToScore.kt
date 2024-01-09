package com.example.footmatch.datos.mappers

import com.example.footmatch.datos.database.FullTimeEntity
import com.example.footmatch.datos.database.HalfTimeEntity
import com.example.footmatch.datos.database.ScoreEntity
import com.example.footmatch.datos.modelos.partido.FullTime
import com.example.footmatch.datos.modelos.partido.HalfTime
import com.example.footmatch.datos.modelos.partido.Score

fun ScoreEntity.toScore(): Score {
    return Score(
        duration = this.duration,
        fullTime = this.fullTime.toFullTime(),
        halfTime = this.halfTime.toHalfTime(),
        winner = this.winner
    )
}

// Funciones de extensión para mapeo FullTimeEntity -> FullTime
fun FullTimeEntity.toFullTime(): FullTime {
    return FullTime(
        away = this.away,
        home = this.home
    )
}

// Funciones de extensión para mapeo HalfTimeEntity -> HalfTime
fun HalfTimeEntity.toHalfTime(): HalfTime {
    return HalfTime(
        away = this.away,
        home = this.home
    )
}