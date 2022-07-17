package com.rojer_ko.stationdetailscreen.di

import kotlin.properties.Delegates.notNull

interface StationDetailsDepsProvider {

    val deps: StationDetailsDeps

    companion object : StationDetailsDepsProvider by StationDetailsDepsStore
}

object StationDetailsDepsStore : StationDetailsDepsProvider {

    override var deps: StationDetailsDeps by notNull()
}