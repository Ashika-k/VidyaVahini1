package com.example.vidyavahini.ui.ping

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.vidyavahini.R

class SelectCurrentStopActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(
            R.layout.activity_select_current_stop
        )

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val routeName =
            intent.getStringExtra("routeName")

        val stopsContainer =
            findViewById<LinearLayout>(
                R.id.stopsContainer
            )

        val stops = when(routeName) {

            "Hassan → Arsikere" -> listOf(
                "Hassan",
                "Vidyanagar",
                "BM Road",
                "Gorur",
                "Arsikere"
            )

            "Hassan → Belur" -> listOf(
                "Hassan",
                "Salagame",
                "Alur",
                "Belur"
            )

            "Hassan → Sakleshpur" -> listOf(
                "Hassan",
                "BM Road",
                "Hongadahalli",
                "Yeslur",
                "Sakleshpur"
            )

            "Hassan → Channarayapatna" -> listOf(
                "Hassan",
                "BM Road",
                "Gandasi",
                "Nuggehalli",
                "Channarayapatna"
            )

            "Hassan → Holenarasipura" -> listOf(
                "Hassan",
                "Gorur",
                "Holenarasipura"
            )

            "Hassan → Alur" -> listOf(
                "Hassan",
                "Salagame",
                "Alur"
            )

            "Hassan → Yeslur" -> listOf(
                "Hassan",
                "BM Road",
                "Hongadahalli",
                "Yeslur"
            )

            else -> emptyList()
        }

        for(stop in stops) {

            val button = Button(this)

            button.text = stop

            button.textSize = 18f

            button.setPadding(
                20,
                20,
                20,
                20
            )

            val params =
                LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )

            params.setMargins(
                0,
                0,
                0,
                24
            )

            button.layoutParams = params

            button.setOnClickListener {

                val intent =
                    Intent(
                        this,
                        PingActivity::class.java
                    )

                intent.putExtra(
                    "stopName",
                    stop
                )

                intent.putExtra(
                    "routeName",
                    routeName
                )

                startActivity(intent)
            }

            stopsContainer.addView(button)
        }
    }

    override fun onSupportNavigateUp(): Boolean {

        finish()

        return true
    }
}