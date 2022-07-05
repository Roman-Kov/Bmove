package com.rojer_ko.stationsscreen.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Text
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.rojer_ko.core.di.ViewModelFactory
import com.rojer_ko.stationsscreen.di.DaggerStationsComponent
import com.rojer_ko.stationsscreen.di.StationsDepsProvider
import javax.inject.Inject

class StationsFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
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
                Text(text = "Hello world!!!")
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getStations()
    }
}