package com.example.imad5112prac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AddSongScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_song_screen)

        val song_title = findViewById<EditText>(R.id.song_title)
        val artist_name = findViewById<EditText>(R.id.artist_name)
        val rating_1_to_5 = findViewById<EditText>(R.id.rating_1_to_5)
        val comments = findViewById<EditText>(R.id.comments)

        val add_song = findViewById<Button>(R.id.add_song)



        add_song?.setOnClickListener {

            val rating_1_to_5_clean = rating_1_to_5 .text.toString().toIntOrNull()

            if (rating_1_to_5_clean != null) {


            }

        }
    }
}