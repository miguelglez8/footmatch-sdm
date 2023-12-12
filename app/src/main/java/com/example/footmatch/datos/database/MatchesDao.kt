package com.example.footmatch.datos.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.footmatch.datos.modelo.MatchEntity

@Dao
interface MatchesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(match: MatchEntity)
    @Delete
    fun delete(match: MatchEntity)
    @Query("SELECT * FROM matches WHERE utc_date BETWEEN :date1 AND :date2")
    fun findByDateBetween(date1: String, date2: String): List<MatchEntity>
}