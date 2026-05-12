package com.example.vidyavahini.ui.ping

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.vidyavahini.R
import com.example.vidyavahini.ui.status.StatusActivity
import com.google.firebase.database.FirebaseDatabase
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class PingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_ping)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val stopName =
            intent.getStringExtra("stopName")

        val routeName =
            intent.getStringExtra("routeName")

        val tvStop =
            findViewById<TextView>(R.id.tvStop)

        val btnPing =
            findViewById<Button>(R.id.btnPing)

        val btnBreakdown =
            findViewById<Button>(R.id.btnBreakdown)

        tvStop.text =
            "📍 Current Stop:\n$stopName"

        val routeKey = when(routeName) {

            "Hassan → Arsikere" ->
                "Hassan_Arsikere"

            "Hassan → Belur" ->
                "Hassan_Belur"

            "Hassan → Sakleshpur" ->
                "Hassan_Sakleshpur"

            "Hassan → Channarayapatna" ->
                "Hassan_Channarayapatna"

            "Hassan → Holenarasipura" ->
                "Hassan_Holenarasipura"

            "Hassan → Alur" ->
                "Hassan_Alur"

            "Hassan → Yeslur" ->
                "Hassan_Yeslur"

            else ->
                "UnknownRoute"
        }

        val database =
            FirebaseDatabase
                .getInstance()
                .reference
                .child("buses")
                .child(routeKey)

        btnPing.setOnClickListener {

            val currentTime =
                SimpleDateFormat(
                    "hh:mm a",
                    Locale.getDefault()
                ).format(Date())

            database.child("route")
                .setValue(routeName)

            database.child("currentStop")
                .setValue(stopName)

            database.child("updatedTime")
                .setValue(currentTime)

            database.child("breakdown")
                .setValue(false)

            Toast.makeText(
                this,
                "Bus Status Updated",
                Toast.LENGTH_SHORT
            ).show()

            val intent =
                Intent(
                    this,
                    StatusActivity::class.java
                )

            intent.putExtra(
                "routeName",
                routeName
            )

            startActivity(intent)
        }

        btnBreakdown.setOnClickListener {

            val currentTime =
                SimpleDateFormat(
                    "hh:mm a",
                    Locale.getDefault()
                ).format(Date())

            database.child("route")
                .setValue(routeName)

            database.child("currentStop")
                .setValue(stopName)

            database.child("updatedTime")
                .setValue(currentTime)

            database.child("breakdown")
                .setValue(true)

            database.child("breakdownMessage")
                .setValue("Bus Breakdown Reported")

            Toast.makeText(
                this,
                "Breakdown Reported",
                Toast.LENGTH_LONG
            ).show()

            val intent =
                Intent(
                    this,
                    StatusActivity::class.java
                )

            intent.putExtra(
                "routeName",
                routeName
            )

            startActivity(intent)
        }
    }

    override fun onSupportNavigateUp(): Boolean {

        finish()

        return true
    }
}