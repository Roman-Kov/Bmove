package com.rojer_ko.repository.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    version = 1, entities = [StationEntity::class], exportSchema = false
)
abstract class StationsDb : RoomDatabase() {

    abstract fun getDao(): StationsDao

    companion object {

        fun createDb(context: Context): StationsDb =
            Room.databaseBuilder(
                context.applicationContext,
                StationsDb::class.java, "${context.cacheDir}/stations.db"
            )
                .fallbackToDestructiveMigration()
                .build()
    }
}