package com.rojer_ko.stationsscreen.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rojer_ko.core.repo.StationsRepository
import com.rojer_ko.model.dto.info.StationsInfo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class StationsViewModel @Inject constructor(private val stationsRepository: StationsRepository) : ViewModel() {

    private val _stations: MutableStateFlow<List<StationsInfo>> = MutableStateFlow(listOf())
    val stations: StateFlow<List<StationsInfo>> = _stations

    fun getStations() = viewModelScope.launch {
        stationsRepository.getStations().let { result ->
            _stations.emit(result)
        }
    }
}