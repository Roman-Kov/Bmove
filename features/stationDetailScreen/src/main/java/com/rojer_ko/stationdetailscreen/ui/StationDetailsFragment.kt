package com.rojer_ko.stationdetailscreen.ui

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.rojer_ko.core.navigator.NavigatorParams
import com.rojer_ko.model.dto.info.StationsInfo
import com.rojer_ko.stationdetailscreen.R
import com.rojer_ko.stationdetailscreen.databinding.FragmentStationDetailsBinding
import com.rojer_ko.stationdetailscreen.di.DaggerStationDetailsComponent
import com.rojer_ko.stationdetailscreen.di.StationDetailsDepsProvider
import com.rojer_ko.stationdetailscreen.di.StationDetailsViewModelFactory
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class StationDetailsFragment : Fragment(R.layout.fragment_station_details) {

    private val binding by viewBinding(FragmentStationDetailsBinding::bind)
    private val stationDetailsComponent by lazy { DaggerStationDetailsComponent.builder().deps(StationDetailsDepsProvider.deps).build() }

    @Inject
    lateinit var viewModelFactory: StationDetailsViewModelFactory
    private val viewModel by lazy { ViewModelProvider(this, viewModelFactory)[StationDetailViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        stationDetailsComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        showStationDetails()
        updateData(false)
    }

    private fun initViews() = with(binding) {
        swipeContainer.setOnRefreshListener {
            updateData(true)
        }

        location.setOnClickListener {
        }
    }

    private fun showStationDetails() = with(binding) {
        (arguments?.getSerializable(NavigatorParams.STATION_INFO.name) as? StationsInfo)?.let { info ->
            lifecycleScope.launchWhenStarted {
                viewModel.getStationDetail(info.station_id).collect { station ->
                    infoContainer.isVisible = true
                    swipeContainer.isRefreshing = false
                    name.text = info.name
                    stationCount.text = station.num_docks_available.toString()
                    pBikeCount.text = station.mechanicalAvailable.toString()
                    eBikeCount.text = station.ebikeAvailable.toString()
                }
            }
        }
    }

    private fun updateData(withRefresh: Boolean) = with(binding) {
        if (withRefresh) {
            swipeContainer.isRefreshing = true
            infoContainer.isVisible = false
        }
        viewModel.updateData()
    }

    companion object {

        fun createInstance(bundle: Bundle): StationDetailsFragment {
            val fragment = StationDetailsFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}