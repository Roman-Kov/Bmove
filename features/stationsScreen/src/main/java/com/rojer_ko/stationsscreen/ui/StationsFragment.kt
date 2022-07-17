package com.rojer_ko.stationsscreen.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.rojer_ko.core.di.ViewModelFactory
import com.rojer_ko.core.navigator.Navigator
import com.rojer_ko.model.dto.info.StationsInfo
import com.rojer_ko.stationsscreen.R
import com.rojer_ko.stationsscreen.di.DaggerStationsComponent
import com.rojer_ko.stationsscreen.di.StationsDepsProvider
import com.rojer_ko.stationsscreen.di.StationsViewModelFactory
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
        LazyColumn {
            items(stations) { station ->
                ShowStation(station = station)
            }
        }
    }

    @Composable
    fun ShowStation(station: StationsInfo) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color.White
                )
                .padding(horizontal = 16.dp, vertical = 5.dp)
                .clickable {
                    navigator.navigateToStationDetails(station.station_id)
                }
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_bike),
                    contentDescription = null,
                    Modifier
                        .size(40.dp)
                )
                if (station.is_charging_station) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_charging),
                        contentDescription = null,
                        Modifier
                            .size(20.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = station.name,
                    color = Color.Black,
                    style = TextStyle(
                        fontSize = 15.sp,
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.W600
                    )
                )
                Text(
                    text = station.physical_configuration,
                    color = Color.Black,
                    style = TextStyle(
                        fontSize = 13.sp,
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.W600
                    )
                )
            }
        }
    }
}