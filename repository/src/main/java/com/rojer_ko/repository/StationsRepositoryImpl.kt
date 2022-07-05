package com.rojer_ko.repository

import com.rojer_ko.core.repo.StationsRepository
import com.rojer_ko.model.Station
import com.rojer_ko.model.dto.info.InfoMainResponse
import com.rojer_ko.model.dto.info.StationsInfo
import com.rojer_ko.model.dto.status.StationsStatus
import com.rojer_ko.model.dto.status.StatusMainResponse
import com.rojer_ko.repository.db.StationEntity.Companion.toEntity
import com.rojer_ko.repository.db.StationsDb
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StationsRepositoryImpl(
    private val httpClient: HttpClient,
    private val stationsDb: StationsDb
) : StationsRepository {

    override suspend fun getStations(): List<StationsInfo> =
        httpClient.get<InfoMainResponse>("${RepositoryConsts.HOSTNAME}station_information").data.stations

    override suspend fun getStationDetails(id: Int): Flow<Station> {
        val dao = stationsDb.getDao()
        return dao.getStation(id).map {
            it.toStation()
        }.also {
            val newData = getStationsStatus().map { it.toEntity() }
            dao.insert(newData)
        }
    }

    private suspend fun getStationsStatus(): List<StationsStatus> =
        httpClient.get<StatusMainResponse>("${RepositoryConsts.HOSTNAME}station_status").data.stations
}