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
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull

class StationsRepositoryImpl(
    private val httpClient: HttpClient,
    private val stationsDb: StationsDb
) : StationsRepository {

    override suspend fun getStations(): List<StationsInfo> = try {
        httpClient.get<InfoMainResponse>("${RepositoryConsts.HOSTNAME}station_information").data.stations
    } catch (e: CancellationException) {
        throw e
    } catch (e: Throwable) {
        e.printStackTrace()
        listOf()
    }

    override suspend fun getStationDetails(id: Int): Flow<Station> {
        val dao = stationsDb.getDao()
        return dao.getStation(id)?.mapNotNull {
            it?.toStation()
        } ?: flowOf()
    }

    override suspend fun updateStationDetails() {
        try {
            val dao = stationsDb.getDao()
            val newData = getStationsStatus().map { it.toEntity() }
            dao.insert(newData)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Throwable) {
            e.printStackTrace()
        }
    }

    private suspend fun getStationsStatus(): List<StationsStatus> = try {
        httpClient.get<StatusMainResponse>("${RepositoryConsts.HOSTNAME}station_status").data.stations
    } catch (e: CancellationException) {
        throw e
    } catch (e: Throwable) {
        e.printStackTrace()
        listOf()
    }
}