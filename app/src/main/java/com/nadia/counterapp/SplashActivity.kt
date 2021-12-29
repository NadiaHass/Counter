package com.nadia.counterapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView

class SplashActivity : AppCompatActivity() {
    private lateinit var zoom : Animation
    private lateinit var circleImageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        zoom = AnimationUtils.loadAnimation(applicationContext , R.anim.zoom)
        circleImageView = findViewById(R.id.circle)
        circleImageView.animation = zoom
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(applicationContext ,MainActivity::class.java ))
            finish()
                                                    },
            3000)
    }
}