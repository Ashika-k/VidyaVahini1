package com.example.vidyavahini.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.vidyavahini.R
import com.example.vidyavahini.ui.routes.RoutesSelectionActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class ChooseOptionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_choose_option)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val btnCheckStatus =
            findViewById<Button>(R.id.btnCheckStatus)

        val btnUpdateStatus =
            findViewById<Button>(R.id.btnUpdateStatus)

        val btnViewRoutes =
            findViewById<Button>(R.id.btnViewRoutes)

        val btnSafeReach =
            findViewById<Button>(R.id.btnSafeReach)

        val btnProfile =
            findViewById<Button>(R.id.btnProfile)

        btnCheckStatus.setOnClickListener {

            val intent =
                Intent(this, SelectStopsActivity::class.java)

            intent.putExtra("mode", "status")

            startActivity(intent)
        }

        btnUpdateStatus.setOnClickListener {

            val intent =
                Intent(this, SelectStopsActivity::class.java)

            intent.putExtra("mode", "update")

            startActivity(intent)
        }

        btnViewRoutes.setOnClickListener {

            val intent =
                Intent(
                    this,
                    RoutesSelectionActivity::class.java
                )

            startActivity(intent)
        }

        btnProfile.setOnClickListener {

        val intent =
            Intent(
                this,
                ProfileActivity::class.java
            )

        startActivity(intent)
    }

        btnSafeReach.setOnClickListener {

            val userId =
                FirebaseAuth
                    .getInstance()
                    .currentUser
                    ?.uid

            if (userId != null) {

                val database =
                    FirebaseDatabase
                        .getInstance()
                        .reference
                        .child("profiles")
                        .child(userId)

                database.get().addOnSuccessListener { snapshot ->

                    val parentEmail =
                        snapshot.child("parentEmail")
                            .value
                            .toString()

                    val studentName =
                        snapshot.child("studentName")
                            .value
                            .toString()

                    AlertDialog.Builder(this)

                        .setTitle("Safe Reach")

                        .setMessage(
                            "Have you safely reached college?"
                        )

                        .setPositiveButton("YES") { _, _ ->

                            val subject =
                                "Safe Reach Confirmation"

                            val message =
                                "${studentName} has safely reached college via VidyaVahini."

                            val intent =
                                Intent(Intent.ACTION_SEND)

                            intent.type =
                                "message/rfc822"

                            intent.putExtra(
                                Intent.EXTRA_EMAIL,
                                arrayOf(parentEmail)
                            )

                            intent.putExtra(
                                Intent.EXTRA_SUBJECT,
                                subject
                            )

                            intent.putExtra(
                                Intent.EXTRA_TEXT,
                                message
                            )

                            startActivity(
                                Intent.createChooser(
                                    intent,
                                    "Send Email"
                                )
                            )
                        }

                        .setNegativeButton(
                            "NO",
                            null
                        )

                        .show()
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {

        finish()

        return true
    }
}