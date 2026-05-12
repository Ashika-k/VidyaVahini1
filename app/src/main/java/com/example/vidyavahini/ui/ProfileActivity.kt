package com.example.vidyavahini.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.vidyavahini.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_profile)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val etStudentName =
            findViewById<EditText>(R.id.etStudentName)

        val etUSN =
            findViewById<EditText>(R.id.etUSN)

        val etStudentPhone =
            findViewById<EditText>(R.id.etStudentPhone)

        val etParentPhone =
            findViewById<EditText>(R.id.etParentPhone)

        val etParentEmail =
            findViewById<EditText>(R.id.etParentEmail)

        val btnSaveProfile =
            findViewById<Button>(R.id.btnSaveProfile)

        btnSaveProfile.setOnClickListener {

            val studentName =
                etStudentName.text.toString()

            val usn =
                etUSN.text.toString()

            val studentPhone =
                etStudentPhone.text.toString()

            val parentPhone =
                etParentPhone.text.toString()

            val parentEmail =
                etParentEmail.text.toString()

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

                database.child("studentName")
                    .setValue(studentName)

                database.child("usn")
                    .setValue(usn)

                database.child("studentPhone")
                    .setValue(studentPhone)

                database.child("parentPhone")
                    .setValue(parentPhone)

                database.child("parentEmail")
                    .setValue(parentEmail)

                Toast.makeText(
                    this,
                    "Profile Saved",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {

        finish()

        return true
    }
}