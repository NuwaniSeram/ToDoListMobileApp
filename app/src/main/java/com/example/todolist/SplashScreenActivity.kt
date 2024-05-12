package com.example.todolist

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var startBtn: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash_screen)

        startBtn = findViewById(R.id.startBtn)

        startBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        // Simulate a delay for splash screen, you can replace it with your actual splash screen logic
        //Thread.sleep(5000)

        // Start the MainActivity after the splash screen
        //startActivity(Intent(this, MainActivity::class.java))

        // Finish the splash screen activity
        //finish()
    }
}
