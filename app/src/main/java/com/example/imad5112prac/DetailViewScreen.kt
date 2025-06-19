package com.example.imad5112prac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DetailViewScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_view_screen)

        val show_songs = findViewById<Button>(R.id.show_songs)
        val show_average_rating = findViewById<Button>(R.id.show_average_rating)
        val return_to_main_screen = findViewById<Button>(R.id.return_to_main_screen)
    }
}