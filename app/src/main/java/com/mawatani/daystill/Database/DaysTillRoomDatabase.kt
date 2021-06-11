package com.mawatani.daystill.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(EventItem::class), version = 1, exportSchema = false)
public abstract class DaysTillRoomDatabase : RoomDatabase() {

    abstract fun eventDao(): EventDao

    companion object{
        // Singleton to stops multiple instances of database
        @Volatile
        private var INSTANCE: DaysTillRoomDatabase? = null

        fun getDatabase(context: Context): DaysTillRoomDatabase{
            //if INSTANCE is !null, return it
            //if null, create INSTANCE
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DaysTillRoomDatabase::class.java,
                    "daysTill_database"
                ).build()
                INSTANCE = instance

                instance
            }
        }
    }
}