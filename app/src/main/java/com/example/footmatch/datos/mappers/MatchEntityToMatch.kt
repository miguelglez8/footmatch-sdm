package com.example.footmatch.datos.mappers

import com.example.footmatch.datos.database.MatchEntity
import com.example.footmatch.datos.modelos.partido.Match

fun MatchEntity.toMatch() : Match {
    return Match(
        awayTeam,
        homeTeam,
        id,
        status,
        score.toScore(),
        utcDate
    )
}