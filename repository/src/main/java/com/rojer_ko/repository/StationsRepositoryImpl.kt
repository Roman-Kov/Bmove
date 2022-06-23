package com.rojer_ko.repository

import com.rojer_ko.core.repo.StationsRepository

class StationsRepositoryImpl : StationsRepository {

    override suspend fun getStations(): List<Any> {
        return listOf("Station_1", "Station_2", "Station_3")
    }

    override suspend fun getStationDetails(id: Int): Any {
        return when (id) {
            1 -> "Station_1"
            2 -> "Station_2"
            3 -> "Station_3"
            else -> "Unknown station"
        }
    }
}