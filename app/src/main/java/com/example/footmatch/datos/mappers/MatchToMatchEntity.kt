package com.example.footmatch.datos.mappers

import com.example.footmatch.datos.database.MatchEntity
import com.example.footmatch.datos.modelos.partido.Match

fun Match.toMatchEntity() : MatchEntity {
    return MatchEntity(
        awayTeam,
        homeTeam,
        id,
        status,
        score.toScoreEntity(),
        utcDate
    )
}
