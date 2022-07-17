package com.rojer_ko.stationdetailscreen.ui

import androidx.lifecycle.ViewModel
import com.rojer_ko.core.repo.StationsRepository
import com.rojer_ko.model.dto.info.StationsInfo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class StationDetailViewModel @Inject constructor(private val stationsRepository: StationsRepository) : ViewModel() {

    private val _stationDetail: MutableStateFlow<List<StationsInfo>> = MutableStateFlow(listOf())
    val stationDetail: StateFlow<List<StationsInfo>> = _stationDetail

    suspend fun getStationDetail(id: Int) = stationsRepository.getStationDetails(id)
}