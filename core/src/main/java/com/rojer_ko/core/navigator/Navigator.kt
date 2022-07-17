package com.rojer_ko.core.navigator

import com.rojer_ko.model.dto.info.StationsInfo

interface Navigator {

    fun setNavigatorListener(listener: ((NavigatorDestination) -> Unit))
    fun navigateToStationDetails(station: StationsInfo)
}