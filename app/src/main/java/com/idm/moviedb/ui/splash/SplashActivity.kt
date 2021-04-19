package com.idm.moviedb.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.idm.moviedb.R
import com.idm.moviedb.ui.home.HomeActivity

class SplashActivity : AppCompatActivity() {
    companion object{
        const val TIME_SPLASH : Long = 1000;
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(mainLooper).postDelayed({
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }, TIME_SPLASH)
    }
}