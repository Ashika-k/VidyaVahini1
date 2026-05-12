package com.example.vidyavahini.ui

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.vidyavahini.R
import com.example.vidyavahini.ui.ping.SelectCurrentStopActivity
import com.example.vidyavahini.ui.route.RouteActivity

class SelectStopsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_select_stops)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val spinnerFrom =
            findViewById<Spinner>(R.id.spinnerFrom)

        val spinnerTo =
            findViewById<Spinner>(R.id.spinnerTo)

        val btnFindRoute =
            findViewById<Button>(R.id.btnFindRoute)

        val mode =
            intent.getStringExtra("mode")

        val stops = listOf(
            "Hassan",
            "Vidyanagar",
            "BM Road",
            "Gorur",
            "Arsikere",
            "Salagame",
            "Alur",
            "Belur",
            "Hongadahalli",
            "Yeslur",
            "Sakleshpur",
            "Gandasi",
            "Nuggehalli",
            "Channarayapatna",
            "Holenarasipura"
        )

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            stops
        )

        spinnerFrom.adapter = adapter
        spinnerTo.adapter = adapter

        btnFindRoute.setOnClickListener {

            val from =
                spinnerFrom.selectedItem.toString()

            val to =
                spinnerTo.selectedItem.toString()

            if (from == to) {

                Toast.makeText(
                    this,
                    "Choose different stops",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            val routeName = findRoute(
                from,
                to
            )

            if (routeName == null) {

                Toast.makeText(
                    this,
                    "No direct route available",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                if (mode == "update") {

                    val intent =
                        Intent(
                            this,
                            SelectCurrentStopActivity::class.java
                        )

                    intent.putExtra(
                        "routeName",
                        routeName
                    )

                    startActivity(intent)

                } else {

                    val intent =
                        Intent(
                            this,
                            RouteActivity::class.java
                        )

                    intent.putExtra(
                        "routeName",
                        routeName
                    )

                    intent.putExtra(
                        "fromStop",
                        from
                    )

                    intent.putExtra(
                        "toStop",
                        to
                    )

                    startActivity(intent)
                }
            }
        }
    }

    private fun findRoute(
        from: String,
        to: String
    ): String? {

        val routes = mapOf(

            "Hassan → Arsikere" to listOf(
                "Hassan",
                "Vidyanagar",
                "BM Road",
                "Gorur",
                "Arsikere"
            ),

            "Hassan → Belur" to listOf(
                "Hassan",
                "Salagame",
                "Alur",
                "Belur"
            ),

            "Hassan → Sakleshpur" to listOf(
                "Hassan",
                "BM Road",
                "Hongadahalli",
                "Yeslur",
                "Sakleshpur"
            ),

            "Hassan → Channarayapatna" to listOf(
                "Hassan",
                "Gandasi",
                "Nuggehalli",
                "Channarayapatna"
            ),

            "Hassan → Holenarasipura" to listOf(
                "Hassan",
                "Gorur",
                "Holenarasipura"
            ),

            "Hassan → Alur" to listOf(
                "Hassan",
                "Salagame",
                "Alur"
            ),

            "Hassan → Yeslur" to listOf(
                "Hassan",
                "BM Road",
                "Hongadahalli",
                "Yeslur"
            )
        )

        for ((routeName, stops) in routes) {

            val fromIndex =
                stops.indexOf(from)

            val toIndex =
                stops.indexOf(to)

            if (
                fromIndex != -1 &&
                toIndex != -1 &&
                fromIndex < toIndex
            ) {

                return routeName
            }
        }

        return null
    }

    override fun onSupportNavigateUp(): Boolean {

        finish()

        return true
    }
}