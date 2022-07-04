package com.rojer_ko.core.repo

import com.rojer_ko.model.info.StationsInfo
import com.rojer_ko.model.status.StationsStatus
import kotlinx.coroutines.flow.Flow

interface StationsRepository {

   suspend fun getStations(): List<StationsInfo>
   suspend fun getStationDetails(id: Int): Flow<StationsStatus>
}