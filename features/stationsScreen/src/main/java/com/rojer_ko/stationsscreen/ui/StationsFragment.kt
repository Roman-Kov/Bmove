package com.rojer_ko.stationsscreen.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.rojer_ko.core.navigator.Navigator
import com.rojer_ko.core.result.onEmpty
import com.rojer_ko.core.result.onLoading
import com.rojer_ko.core.result.onSuccess
import com.rojer_ko.model.dto.info.StationsInfo
import com.rojer_ko.stationsscreen.di.DaggerStationsComponent
import com.rojer_ko.stationsscreen.di.StationsDepsProvider
import com.rojer_ko.stationsscreen.di.StationsViewModelFactory
import com.rojer_ko.uicore.Items
import com.rojer_ko.uicore.ProgressBars
import javax.inject.Inject

class StationsFragment : Fragment() {

    @Inject
    lateinit var navigator: Navigator

    @Inject
    lateinit var viewModelFactory: StationsViewModelFactory

    private val stationsComponent by lazy { DaggerStationsComponent.builder().deps(StationsDepsProvider.deps).build() }
    private val viewModel by lazy { ViewModelProvider(this, viewModelFactory)[StationsViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        stationsComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                ShowStations()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getStations()
    }

    @Composable
    private fun ShowStations() {
        val stations by viewModel.stations.collectAsState()
        stations
            .onEmpty {
            }
            .onLoading {
                ProgressBars.SimpleProgressBar()
            }
            .onSuccess { stationsInfo ->
                LazyColumn {
                    items(stationsInfo) { station ->
                        ShowStation(station = station)
                    }
                }
            }
    }

    @Composable
    fun ShowStation(station: StationsInfo) {
        Items.StationItem(station) {
            navigator.navigateToStationDetails(station)
        }
    }
}