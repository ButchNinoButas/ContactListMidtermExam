package com.butas_butchnino.midtermexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val button: Button = findViewById(R.id.button2)

        // Set OnClickListener to the button
        button.setOnClickListener {
            // Start the new activity here
            val intent = Intent(this, ContactList::class.java)
            startActivity(intent)
        }
        val rbutton: Button = findViewById(R.id.button3)

        // Set OnClickListener to the button
        rbutton.setOnClickListener {
            // Start the new activity here
            val intent = Intent(this, ArchivedList::class.java)
            startActivity(intent)
        }
    }
}