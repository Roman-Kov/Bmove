package com.rojer_ko.model

data class Station(
    val station_id: Int = -1,
    val num_bikes_available: Int = 0,
    val mechanicalAvailable: Int= 0,
    val ebikeAvailable: Int= 0,
    val num_docks_available: Int= 0,
    val last_reported: Long = 0L,
    val is_charging_station: Boolean = false
)