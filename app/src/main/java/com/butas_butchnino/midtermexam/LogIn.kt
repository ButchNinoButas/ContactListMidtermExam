package com.butas_butchnino.midtermexam

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LogIn : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        val button: Button = findViewById(R.id.button1)

        // Set OnClickListener to the button
        button.setOnClickListener {
            // Start the new activity here
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }
    }
}