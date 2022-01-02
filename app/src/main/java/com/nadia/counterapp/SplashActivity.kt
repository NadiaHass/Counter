package com.nadia.counterapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.bumptech.glide.Glide

class SplashActivity : AppCompatActivity() {
    private lateinit var zoom : Animation
    private lateinit var circleImageView: ImageView
    private lateinit var backgroundImageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        zoom = AnimationUtils.loadAnimation(applicationContext , R.anim.zoom)
        circleImageView = findViewById(R.id.iv_circle)
        backgroundImageView = findViewById(R.id.iv_background)
        circleImageView.animation = zoom

        loadImage()
        zoomCircleImage()

    }
    private fun zoomCircleImage(){
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(applicationContext ,MainActivity::class.java ))
            finish() },
            3000)
    }
    private fun loadImage(){
        val url = "https://i.picsum.photos/id/229/800/600.jpg?hmac=XBz4BdHCdXDT8GerLNU_gH41Hv6gKY0beR0wprsUesQ"
        Glide.with(this)
            .load(url)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(backgroundImageView)
    }

}