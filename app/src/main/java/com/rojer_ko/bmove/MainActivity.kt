package com.rojer_ko.bmove

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.rojer_ko.bmove.databinding.ActivityMainBinding
import com.rojer_ko.stationsscreen.ui.StationsFragment

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding :: bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startFragment = StationsFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(binding.container.id, startFragment)
            .commit()
    }
}