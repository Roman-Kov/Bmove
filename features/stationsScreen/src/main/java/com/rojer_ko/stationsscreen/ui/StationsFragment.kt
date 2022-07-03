package com.rojer_ko.stationsscreen.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.rojer_ko.core.di.ViewModelFactory
import com.rojer_ko.stationsscreen.R
import com.rojer_ko.stationsscreen.databinding.FragmentStationsBinding
import com.rojer_ko.stationsscreen.di.DaggerStationsComponent
import com.rojer_ko.stationsscreen.di.StationsDepsProvider
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class StationsFragment : Fragment(R.layout.fragment_stations) {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val stationsComponent by lazy { DaggerStationsComponent.builder().deps(StationsDepsProvider.deps).build() }
    private val viewModel by lazy { ViewModelProvider(this, viewModelFactory)[StationsViewModel::class.java] }
    private val viewBinding by viewBinding(FragmentStationsBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        stationsComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getStations()

        lifecycleScope.launchWhenStarted {
            viewModel.stations.collect {
                viewBinding.text.text = it.toString()
            }
        }
    }
}