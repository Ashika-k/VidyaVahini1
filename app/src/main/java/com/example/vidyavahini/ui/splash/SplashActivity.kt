package com.example.vidyavahini.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.vidyavahini.R
import com.example.vidyavahini.ui.login.LoginActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        Handler(Looper.getMainLooper()).postDelayed({

            startActivity(
                Intent(this, LoginActivity::class.java)
            )

            finish()

        }, 2000)
    }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}