package com.rojer_ko.repository

import com.rojer_ko.core.repo.StationsRepository
import com.rojer_ko.model.info.InfoMainResponse
import com.rojer_ko.model.info.StationsInfo
import com.rojer_ko.model.status.StationsStatus
import com.rojer_ko.model.status.StatusMainResponse
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class StationsRepositoryImpl(
    private val httpClient: HttpClient
) : StationsRepository {

    override suspend fun getStations(): List<StationsInfo> =
        httpClient.get<InfoMainResponse>("${RepositoryConsts.HOSTNAME}station_information").data.stations

    override suspend fun getStationDetails(id: Int): Flow<StationsStatus> {
        return flowOf()
    }

    private suspend fun getStationsStatus(): List<StationsStatus> =
        httpClient.get<StatusMainResponse>("${RepositoryConsts.HOSTNAME}station_status").data.stations
}