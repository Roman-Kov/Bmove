package com.rojer_ko.repository.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.rojer_ko.model.Station
import com.rojer_ko.model.dto.status.StationsStatus

@Entity
data class StationEntity(
    @PrimaryKey
    val station_id: Int,
    val num_bikes_available: Int,
    val mechanicalAvailable: Int,
    val ebikeAvailable: Int,
    val num_docks_available: Int,
    val last_reported: Long,
    val is_charging_station: Boolean
) {

    fun toStation(): Station = Station(
        station_id = station_id,
        num_bikes_available = num_bikes_available,
        mechanicalAvailable = mechanicalAvailable,
        ebikeAvailable = ebikeAvailable,
        num_docks_available = num_docks_available,
        last_reported = last_reported,
        is_charging_station = is_charging_station
    )

    companion object {

        fun StationsStatus.toEntity(): StationEntity = StationEntity(
            station_id = this.station_id,
            num_bikes_available = this.num_bikes_available,
            mechanicalAvailable = this.num_bikes_available_types.mechanical,
            ebikeAvailable = this.num_bikes_available_types.ebike,
            num_docks_available = this.num_docks_available,
            last_reported = this.last_reported,
            is_charging_station = this.is_charging_station
        )
    }
}