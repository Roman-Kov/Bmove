package com.rojer_ko.stationsscreen.ui

import androidx.lifecycle.ViewModel
import com.rojer_ko.stationsscreen.di.DaggerStationsComponent

internal class StationsViewModel: ViewModel() {

    val stationsComponent = DaggerStationsComponent.builder().build()
}