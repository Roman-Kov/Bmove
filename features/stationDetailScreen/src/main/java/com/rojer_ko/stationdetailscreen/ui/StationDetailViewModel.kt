package com.rojer_ko.stationdetailscreen.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rojer_ko.core.repo.StationsRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class StationDetailViewModel @Inject constructor(private val stationsRepository: StationsRepository) : ViewModel() {

    suspend fun getStationDetail(id: Int) = stationsRepository.getStationDetails(id)

    fun updateData() = viewModelScope.launch {
        stationsRepository.updateStationDetails()
    }
}