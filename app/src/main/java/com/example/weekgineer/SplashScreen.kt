package com.example.weekgineer

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val logo = findViewById<ImageView>(R.id.imgLogo)
        val animation = AnimationUtils.loadAnimation(this, R.anim.scale_up)
        logo.startAnimation(animation)

        // Espera 2 segundos antes de ir a MainActivity
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 2000) // 2000 milisegundos = 2 segundos
    }
}
