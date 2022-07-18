package com.rojer_ko.stationsscreen.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rojer_ko.core.repo.StationsRepository
import com.rojer_ko.core.result.AppResult
import com.rojer_ko.model.dto.info.StationsInfo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class StationsViewModel @Inject constructor(private val stationsRepository: StationsRepository) : ViewModel() {

    private val _stations: MutableStateFlow<AppResult<List<StationsInfo>>> = MutableStateFlow(AppResult.Empty)
    val stations: StateFlow<AppResult<List<StationsInfo>>> = _stations

    fun getStations() = viewModelScope.launch {
        _stations.emit(AppResult.Loading)
        stationsRepository.getStations().let { result ->
            _stations.emit(AppResult.Success(result))
        }
    }
}