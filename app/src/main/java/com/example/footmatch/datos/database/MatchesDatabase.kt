package com.example.footmatch.datos.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [MatchEntity::class], version = 1, exportSchema = false)
abstract class MatchesDatabase : RoomDatabase() {
    abstract fun matchesDao(): MatchesDao
    companion object {
        @Volatile
        private var INSTANCE: MatchesDatabase? = null
        fun getDatabase(context: Context?): MatchesDatabase {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(context!!.applicationContext,
                    MatchesDatabase::class.java,
                    "matchesdb").build()
                INSTANCE = instance
                instance
            }
        }
    }
}