package com.rojer_ko.model

data class Station(
    val station_id: Int,
    val num_bikes_available: Int,
    val mechanicalAvailable: Int,
    val ebikeAvailable: Int,
    val num_docks_available: Int,
    val last_reported: Long,
    val is_charging_station: Boolean
)