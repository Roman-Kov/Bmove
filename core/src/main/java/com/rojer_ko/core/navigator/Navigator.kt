package com.rojer_ko.core.navigator

interface Navigator {

    fun setNavigatorListener(listener: ((NavigatorDestination) -> Unit))
    fun navigateToStationDetails(id: Int)
}