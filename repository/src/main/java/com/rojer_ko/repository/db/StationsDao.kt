package com.rojer_ko.repository.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface StationsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(stations: List<StationEntity>): List<Long>

    @Query("SELECT * FROM StationEntity WHERE station_id = :id")
    fun getStation(id: Int): Flow<StationEntity>
}