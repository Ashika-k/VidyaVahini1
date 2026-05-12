package com.example.vidyavahini.ui.busstops

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.vidyavahini.R
import com.example.vidyavahini.ui.ping.PingActivity
import com.example.vidyavahini.ui.status.StatusActivity

class BusStopsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bus_stops)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val btnCollegeGate = findViewById<Button>(R.id.btnCollegeGate)
        val btnMainRoad = findViewById<Button>(R.id.btnMainRoad)
        val btnBusStand = findViewById<Button>(R.id.btnBusStand)
        val btnRailwayStation = findViewById<Button>(R.id.btnRailwayStation)
        val btnMarket = findViewById<Button>(R.id.btnMarket)

        btnCollegeGate.setOnClickListener {
            startActivity(Intent(this, StatusActivity::class.java))
        }

        btnMainRoad.setOnClickListener {
            startActivity(Intent(this, PingActivity::class.java))
        }

        btnBusStand.setOnClickListener {
            startActivity(Intent(this, StatusActivity::class.java))
        }

        btnRailwayStation.setOnClickListener {
            startActivity(Intent(this, PingActivity::class.java))
        }

        btnMarket.setOnClickListener {
            startActivity(Intent(this, StatusActivity::class.java))
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}