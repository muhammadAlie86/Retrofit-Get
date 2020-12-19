package com.alie.submission.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import android.widget.TextView
import com.alie.submission.R

class SplashActivity : AppCompatActivity() {


    private lateinit var imgSplash : ImageView
    private lateinit var tvAppName : TextView
    private var delayMillis = 3000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

    imgSplash = findViewById(R.id.imgSplash)
    tvAppName = findViewById(R.id.tvSplash)


    val handler = Handler()
    handler.postDelayed( {
        kotlin.run {
            val intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    },delayMillis)
    }
}