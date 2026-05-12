package com.example.vidyavahini.ui.status

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.vidyavahini.R
import com.google.firebase.database.*

class StatusActivity : AppCompatActivity() {

    private lateinit var tvRoute: TextView
    private lateinit var tvBusInfo: TextView
    private lateinit var tvRouteLine: TextView

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_status)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        tvRoute =
            findViewById(R.id.tvRoute)

        tvBusInfo =
            findViewById(R.id.tvBusInfo)

        tvRouteLine =
            findViewById(R.id.tvRouteLine)

        val routeName =
            intent.getStringExtra("routeName")

        val destinationStop =
            intent.getStringExtra("destinationStop")

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

        val routeStops = mapOf(

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
                "BM Road",
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

        val routeTimings = mapOf(

            "Hassan → Arsikere" to listOf(
                5,
                4,
                8,
                12
            ),

            "Hassan → Belur" to listOf(
                6,
                10,
                12
            ),

            "Hassan → Sakleshpur" to listOf(
                5,
                12,
                10,
                15
            ),

            "Hassan → Channarayapatna" to listOf(
                5,
                10,
                8,
                10
            ),

            "Hassan → Holenarasipura" to listOf(
                10,
                14
            ),

            "Hassan → Alur" to listOf(
                6,
                10
            ),

            "Hassan → Yeslur" to listOf(
                5,
                12,
                10
            )
        )

        database =
            FirebaseDatabase
                .getInstance()
                .reference
                .child("buses")
                .child(routeKey)

        database.addValueEventListener(
            object : ValueEventListener {

                override fun onDataChange(
                    snapshot: DataSnapshot
                ) {

                    val route =
                        snapshot.child("route")
                            .value
                            .toString()

                    val stop =
                        snapshot.child("currentStop")
                            .value
                            .toString()

                    val updatedTime =
                        snapshot.child("updatedTime")
                            .value
                            .toString()

                    val breakdown =
                        snapshot.child("breakdown")
                            .value
                            .toString()

                    val breakdownMessage =
                        snapshot.child("breakdownMessage")
                            .value
                            .toString()

                    tvRoute.text =
                        "🚌 $route"

                    val stops =
                        routeStops[route]
                            ?: emptyList()

                    val timings =
                        routeTimings[route]
                            ?: emptyList()

                    val routeLineBuilder =
                        StringBuilder()

                    for (routeStop in stops) {

                        if (routeStop == stop) {

                            routeLineBuilder.append(
                                "🟣 🚌 $routeStop\n│\n"
                            )

                        } else {

                            routeLineBuilder.append(
                                "⚪ $routeStop\n│\n"
                            )
                        }
                    }

                    tvRouteLine.text =
                        routeLineBuilder.toString()

                    var eta = 0

                    val currentIndex =
                        stops.indexOf(stop)

                    val destinationIndex =
                        stops.indexOf(destinationStop)

                    if (
                        currentIndex != -1 &&
                        destinationIndex != -1 &&
                        currentIndex < destinationIndex
                    ) {

                        for (
                        i in currentIndex until destinationIndex
                        ) {

                            eta += timings[i]
                        }
                    }

                    if (breakdown == "true") {

                        tvBusInfo.setTextColor(
                            Color.parseColor("#D32F2F")
                        )

                        tvBusInfo.text =
                            """
                            ⚠ $breakdownMessage
                            
                            📍 Last Known Stop:
                            $stop
                            
                            🕒 Reported At:
                            $updatedTime
                            
                            Please arrange alternative transport.
                            """.trimIndent()

                    } else {

                        tvBusInfo.setTextColor(
                            Color.parseColor("#333333")
                        )

                        tvBusInfo.text =
                            """
                            📍 Current Stop:
                            $stop
                            
                            🕒 Updated At:
                            $updatedTime
                            
                            ⏳ ETA to Destination:
                            $eta mins
                            """.trimIndent()
                    }
                }

                override fun onCancelled(
                    error: DatabaseError
                ) {

                }
            }
        )
    }

    override fun onSupportNavigateUp(): Boolean {

        finish()

        return true
    }
}