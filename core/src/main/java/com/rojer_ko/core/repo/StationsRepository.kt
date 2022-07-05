package com.rojer_ko.core.repo

import com.rojer_ko.model.Station
import com.rojer_ko.model.dto.info.StationsInfo
import kotlinx.coroutines.flow.Flow

interface StationsRepository {

   suspend fun getStations(): List<StationsInfo>
   suspend fun getStationDetails(id: Int): Flow<Station>
}