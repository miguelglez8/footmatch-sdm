package com.example.footmatch.datos.mappers

import com.example.footmatch.datos.database.FullTimeEntity
import com.example.footmatch.datos.database.HalfTimeEntity
import com.example.footmatch.datos.database.ScoreEntity
import com.example.footmatch.datos.modelos.partido.FullTime
import com.example.footmatch.datos.modelos.partido.HalfTime
import com.example.footmatch.datos.modelos.partido.Score

// Funciones de extensión para mapeo Score -> ScoreEntity
fun Score.toScoreEntity(): ScoreEntity {
    return ScoreEntity(
        duration = this.duration,
        fullTime = this.fullTime.toFullTimeEntity(),
        halfTime = this.halfTime.toHalfTimeEntity(),
        winner = this.winner
    )
}

// Funciones de extensión para mapeo FullTime -> FullTimeEntity
fun FullTime.toFullTimeEntity(): FullTimeEntity {
    return FullTimeEntity(
        away = this.away,
        home = this.home
    )
}

// Funciones de extensión para mapeo HalfTime -> HalfTimeEntity
fun HalfTime.toHalfTimeEntity(): HalfTimeEntity {
    return HalfTimeEntity(
        away = this.away,
        home = this.home
    )
}