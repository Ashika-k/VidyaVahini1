package com.example.vidyavahini.ui.routes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.vidyavahini.R

class RoutesSelectionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_routes_selection)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val btnArsikere =
            findViewById<Button>(R.id.btnArsikere)

        val btnBelur =
            findViewById<Button>(R.id.btnBelur)

        val btnSakleshpur =
            findViewById<Button>(R.id.btnSakleshpur)

        val btnChannarayapatna =
            findViewById<Button>(R.id.btnChannarayapatna)

        val btnHolenarasipura =
            findViewById<Button>(R.id.btnHolenarasipura)

        val btnAlur =
            findViewById<Button>(R.id.btnAlur)

        val btnYeslur =
            findViewById<Button>(R.id.btnYeslur)

        btnArsikere.setOnClickListener {

            openRoute(
                "Hassan → Arsikere"
            )
        }

        btnBelur.setOnClickListener {

            openRoute(
                "Hassan → Belur"
            )
        }

        btnSakleshpur.setOnClickListener {

            openRoute(
                "Hassan → Sakleshpur"
            )
        }

        btnChannarayapatna.setOnClickListener {

            openRoute(
                "Hassan → Channarayapatna"
            )
        }

        btnHolenarasipura.setOnClickListener {

            openRoute(
                "Hassan → Holenarasipura"
            )
        }

        btnAlur.setOnClickListener {

            openRoute(
                "Hassan → Alur"
            )
        }

        btnYeslur.setOnClickListener {

            openRoute(
                "Hassan → Yeslur"
            )
        }
    }

    private fun openRoute(routeName: String) {

        val intent =
            Intent(this, RouteInfoActivity::class.java)

        intent.putExtra(
            "routeName",
            routeName
        )

        startActivity(intent)
    }

    override fun onSupportNavigateUp(): Boolean {

        finish()

        return true
    }
}