package com.example.footmatch.datos.mappers.match

import com.example.footmatch.datos.modelo.MatchEntity
import com.example.footmatch.datos.modelo.pojos.partido.Match

fun MatchEntity.toMatch() : Match {
    return Match(
        area,
        awayTeam,
        competition,
        group,
        homeTeam,
        id,
        lastUpdated,
        matchday,
        odds,
        referees,
        score,
        season,
        stage,
        status,
        utcDate
    )
}