package com.example.imad5112prac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val add_to_playlist = findViewById<Button>(R.id.add_to_playlist)
        val view_details = findViewById<Button>(R.id.view_details)
        val exit_app = findViewById<Button>(R.id.exit_app)


    }
}