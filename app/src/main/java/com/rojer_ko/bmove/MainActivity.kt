package com.rojer_ko.bmove

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.rojer_ko.bmove.databinding.ActivityMainBinding
import com.rojer_ko.core.navigator.Navigator
import com.rojer_ko.core.navigator.NavigatorScreens
import com.rojer_ko.model.dto.info.StationsInfo
import com.rojer_ko.stationdetailscreen.ui.StationDetailsFragment
import com.rojer_ko.stationsscreen.ui.StationsFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var navigator: Navigator
    private val binding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        App.appComponent.inject(this)
        val startFragment = StationsFragment()
        navigate(startFragment)

        navigator.setNavigatorListener { navDestination ->
            when (navDestination.screen) {
                NavigatorScreens.STATION_DETAILS -> {
                    val fragment = StationDetailsFragment.createInstance(navDestination.params)
                    navigate(fragment)
                }
                NavigatorScreens.MAP -> {
                    (navDestination.params.getSerializable(NavigatorScreens.MAP.name) as? StationsInfo)?.let {
                        openMap(it)
                    }
                }
            }
        }
    }

    private fun navigate(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(binding.container.id, fragment)
            .addToBackStack("main")
            .commit()
    }

    private fun openMap(stationsInfo: StationsInfo) {
        val geoUriString = "geo:${stationsInfo.lat}, ${stationsInfo.lon}"
        val geoUri: Uri = Uri.parse(geoUriString)
        val mapIntent = Intent(Intent.ACTION_VIEW, geoUri)
        startActivity(mapIntent)
    }
}