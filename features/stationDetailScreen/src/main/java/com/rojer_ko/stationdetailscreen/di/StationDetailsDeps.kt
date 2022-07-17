package com.rojer_ko.stationdetailscreen.di

import com.rojer_ko.core.navigator.Navigator
import com.rojer_ko.core.repo.StationsRepository

interface StationDetailsDeps {

    val stationsRepo: StationsRepository
    val navigator: Navigator
}