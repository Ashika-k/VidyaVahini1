package com.example.vidyavahini.ui.routes

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.vidyavahini.R

class RouteInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_route_info)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvBusNumber =
            findViewById<TextView>(R.id.tvBusNumber)

        val tvDriver =
            findViewById<TextView>(R.id.tvDriver)

        val tvRouteFlow =
            findViewById<TextView>(R.id.tvRouteFlow)

        val routeName =
            intent.getStringExtra("routeName")

        when(routeName) {

            "Hassan → Arsikere" -> {

                tvBusNumber.text =
                    "KA-13-B-1021"

                tvDriver.text =
                    "Ramesh"

                tvRouteFlow.text =
                    """
                    Hassan
                    ↓
                    Vidyanagar
                    ↓
                    BM Road
                    ↓
                    Gorur
                    ↓
                    Arsikere
                    """.trimIndent()
            }

            "Hassan → Belur" -> {

                tvBusNumber.text =
                    "KA-13-B-2045"

                tvDriver.text =
                    "Suresh"

                tvRouteFlow.text =
                    """
                    Hassan
                    ↓
                    Salagame
                    ↓
                    Alur
                    ↓
                    Belur
                    """.trimIndent()
            }

            "Hassan → Sakleshpur" -> {

                tvBusNumber.text =
                    "KA-13-B-3099"

                tvDriver.text =
                    "Manju"

                tvRouteFlow.text =
                    """
                    Hassan
                    ↓
                    BM Road
                    ↓
                    Hongadahalli
                    ↓
                    Yeslur
                    ↓
                    Sakleshpur
                    """.trimIndent()
            }

            "Hassan → Channarayapatna" -> {

                tvBusNumber.text =
                    "KA-13-B-4102"

                tvDriver.text =
                    "Lokesh"

                tvRouteFlow.text =
                    """
                    Hassan
                    ↓
                    BM Road
                    ↓
                    Gandasi
                    ↓
                    Nuggehalli
                    ↓
                    Channarayapatna
                    """.trimIndent()
            }

            "Hassan → Holenarasipura" -> {

                tvBusNumber.text =
                    "KA-13-B-5110"

                tvDriver.text =
                    "Prakash"

                tvRouteFlow.text =
                    """
                    Hassan
                    ↓
                    Gorur
                    ↓
                    Holenarasipura
                    """.trimIndent()
            }

            "Hassan → Alur" -> {

                tvBusNumber.text =
                    "KA-13-B-6201"

                tvDriver.text =
                    "Harish"

                tvRouteFlow.text =
                    """
                    Hassan
                    ↓
                    Salagame
                    ↓
                    Alur
                    """.trimIndent()
            }

            "Hassan → Yeslur" -> {

                tvBusNumber.text =
                    "KA-13-B-7315"

                tvDriver.text =
                    "Naveen"

                tvRouteFlow.text =
                    """
                    Hassan
                    ↓
                    BM Road
                    ↓
                    Hongadahalli
                    ↓
                    Yeslur
                    """.trimIndent()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {

        finish()

        return true
    }
}