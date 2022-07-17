package com.rojer_ko.bmove

import androidx.core.os.bundleOf
import com.rojer_ko.core.navigator.Navigator
import com.rojer_ko.core.navigator.NavigatorDestination
import com.rojer_ko.core.navigator.NavigatorParams
import com.rojer_ko.core.navigator.NavigatorScreens

class NavigatorImpl : Navigator {

    var navListener: ((NavigatorDestination) -> Unit)? = null

    override fun setNavigatorListener(listener: (NavigatorDestination) -> Unit) {
        navListener = listener
    }

    override fun navigateToStationDetails(id: Int) {
        navListener?.invoke(
            NavigatorDestination(
                NavigatorScreens.STATION_DETAILS,
                bundleOf(NavigatorParams.STATION_ID.name to id)
            )
        )
    }
}