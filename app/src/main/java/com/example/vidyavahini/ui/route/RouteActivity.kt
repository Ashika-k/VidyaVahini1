package com.example.vidyavahini.ui.route

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.vidyavahini.R
import com.example.vidyavahini.ui.status.StatusActivity

class RouteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_route)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvFrom =
            findViewById<TextView>(R.id.tvFrom)

        val tvTo =
            findViewById<TextView>(R.id.tvTo)

        val btnRoute =
            findViewById<Button>(R.id.btnRoute)

        val tvNoRoute =
            findViewById<TextView>(R.id.tvNoRoute)

        val from =
            intent.getStringExtra("fromStop") ?: ""

        val to =
            intent.getStringExtra("toStop") ?: ""

        tvFrom.text = "From: $from"

        tvTo.text = "To: $to"

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

            "Hassan → Yeslur" to listOf(
                "Hassan",
                "Hongadahalli",
                "Yeslur"
            )
        )

        var matchedRoute: String? = null

        for ((routeName, stops) in routes) {

            if (
                stops.contains(from) &&
                stops.contains(to) &&
                stops.indexOf(from) < stops.indexOf(to)
            ) {

                matchedRoute = routeName
                break
            }
        }

        if (matchedRoute != null) {

            btnRoute.visibility = View.VISIBLE

            tvNoRoute.visibility = View.GONE

            btnRoute.text = matchedRoute

            btnRoute.setOnClickListener {

                val intent =
                    Intent(
                        this,
                        StatusActivity::class.java
                    )

                intent.putExtra(
                    "routeName",
                    matchedRoute
                )

                intent.putExtra(
                    "destinationStop",
                    to
                )

                startActivity(intent)
            }

        } else {

            btnRoute.visibility = View.GONE

            tvNoRoute.visibility = View.VISIBLE
        }
    }

    override fun onSupportNavigateUp(): Boolean {

        finish()

        return true
    }
}