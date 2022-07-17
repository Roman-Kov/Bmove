package com.rojer_ko.stationdetailscreen.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Text
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.rojer_ko.core.navigator.NavigatorParams

class StationDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val id = arguments?.getInt(NavigatorParams.STATION_ID.name).toString()
                Text("ID: $id")
            }
        }
    }

    companion object {

        fun createInstance(bundle: Bundle): StationDetailsFragment {
            val fragment = StationDetailsFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}