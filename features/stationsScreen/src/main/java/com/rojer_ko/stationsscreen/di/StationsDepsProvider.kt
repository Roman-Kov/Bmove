package com.rojer_ko.stationsscreen.di

import kotlin.properties.Delegates.notNull

interface StationsDepsProvider {

    val deps: StationsDeps

    companion object : StationsDepsProvider by StationsDepsStore
}

object StationsDepsStore : StationsDepsProvider {

    override var deps: StationsDeps by notNull()
}