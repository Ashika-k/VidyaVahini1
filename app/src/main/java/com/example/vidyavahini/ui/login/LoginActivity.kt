package com.example.vidyavahini.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.vidyavahini.R
import com.example.vidyavahini.ui.ChooseOptionActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        supportActionBar?.hide()

        auth =
            FirebaseAuth.getInstance()

        val etEmail =
            findViewById<EditText>(R.id.etEmail)

        val etPassword =
            findViewById<EditText>(R.id.etPassword)

        val btnLogin =
            findViewById<Button>(R.id.btnLogin)

        val btnSignup =
            findViewById<Button>(R.id.btnSignup)

        val tvForgotPassword =
            findViewById<TextView>(
                R.id.tvForgotPassword
            )

        btnSignup.setOnClickListener {

            val email =
                etEmail.text.toString().trim()

            val password =
                etPassword.text.toString().trim()

            if (
                email.isEmpty() ||
                password.isEmpty()
            ) {

                Toast.makeText(
                    this,
                    "Enter email and password",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            auth.createUserWithEmailAndPassword(
                email,
                password
            ).addOnCompleteListener {

                if (it.isSuccessful) {

                    auth.currentUser
                        ?.sendEmailVerification()

                    Toast.makeText(
                        this,
                        "Verification mail sent",
                        Toast.LENGTH_LONG
                    ).show()

                } else {

                    Toast.makeText(
                        this,
                        it.exception?.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        btnLogin.setOnClickListener {

            val email =
                etEmail.text.toString().trim()

            val password =
                etPassword.text.toString().trim()

            auth.signInWithEmailAndPassword(
                email,
                password
            ).addOnCompleteListener {

                if (it.isSuccessful) {

                    val user =
                        auth.currentUser

                    if (
                        user != null &&
                        user.isEmailVerified
                    ) {

                        val intent =
                            Intent(
                                this,
                                ChooseOptionActivity::class.java
                            )

                        startActivity(intent)

                        finish()

                    } else {

                        Toast.makeText(
                            this,
                            "Verify your email first",
                            Toast.LENGTH_LONG
                        ).show()
                    }

                } else {

                    Toast.makeText(
                        this,
                        "Login Failed",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        tvForgotPassword.setOnClickListener {

            val email =
                etEmail.text.toString().trim()

            if (email.isEmpty()) {

                Toast.makeText(
                    this,
                    "Enter email first",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            auth.sendPasswordResetEmail(email)
                .addOnCompleteListener {

                    if (it.isSuccessful) {

                        Toast.makeText(
                            this,
                            "Reset mail sent",
                            Toast.LENGTH_LONG
                        ).show()

                    } else {

                        Toast.makeText(
                            this,
                            "Failed to send mail",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }
    }
}