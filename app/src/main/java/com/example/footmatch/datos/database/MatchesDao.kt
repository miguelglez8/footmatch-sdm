package com.example.footmatch.datos.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MatchesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(match: MatchEntity)
    @Delete
    fun delete(match: MatchEntity)
    @Query("SELECT * FROM matches WHERE SUBSTR(utc_date, 1, 10) = :date")
    fun findByDate(date: String): List<MatchEntity>

}