package com.rojer_ko.stationsscreen.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rojer_ko.core.repo.StationsRepository
import com.rojer_ko.stationsscreen.di.DaggerStationsComponent
import com.rojer_ko.stationsscreen.di.StationsDepsProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class StationsViewModel @Inject constructor(private val stationsRepository: StationsRepository) : ViewModel() {

    private val _stations: MutableStateFlow<List<String>> = MutableStateFlow(listOf())
    val stations: StateFlow<List<String>> = _stations

    fun getStations() = viewModelScope.launch {
        stationsRepository.getStations().let { result ->
            _stations.emit(result as List<String>)
        }
    }
}