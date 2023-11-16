package com.example.a90sbox


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import com.bumptech.glide.Glide

class SplashActivity : AppCompatActivity() {

    private val SPLASH_DELAY = 2500 //Delay in Seconds

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme1)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //Load and Display GIF
        val imageview = findViewById<ImageView>(R.id.splashImageView)
        Glide.with(this)
            .asGif()
            .load(R.raw.intro)
            .into(imageview)

        //Delay and then launch main activity
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_DELAY.toLong() )

    }
    }
