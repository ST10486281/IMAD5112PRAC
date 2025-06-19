package com.example.imad5112prac

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class AddSongScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_song_screen)

        // Get references to input fields
        val song_title = findViewById<EditText>(R.id.song_title)
        val artist_name = findViewById<EditText>(R.id.artist_name)
        val rating_1_to_5 = findViewById<EditText>(R.id.rating_1_to_5)
        val comments = findViewById<EditText>(R.id.comments)

        val add_song = findViewById<Button>(R.id.add_song)
        val errors = findViewById<TextView>(R.id.errors)

        // Read song count from Intent extras
        val songCount = intent.getIntExtra("songCount", 0)

        add_song.setOnClickListener {
            errors.text = "" // Clear previous errors

            // Check if playlist is already full
            if (songCount >= 4) {
                Toast.makeText(this, "Playlist is full. Cannot add more songs.", Toast.LENGTH_SHORT).show()
                finish()  // Return to MainActivity
                return@setOnClickListener
            }

            // Read and validate user input
            val title = song_title.text.toString().trim()
            val artist = artist_name.text.toString().trim()
            val ratingString = rating_1_to_5.text.toString().trim()
            val comment = comments.text.toString().trim()

            if (title.isEmpty() || artist.isEmpty() || ratingString.isEmpty()) {
                errors.text = "Please fill in all fields."
                return@setOnClickListener
            }

            val rating = ratingString.toIntOrNull()
            if (rating == null || rating < 1 || rating > 5) {
                errors.text = "Rating must be a number between 1 and 5."
                return@setOnClickListener
            }

            // All inputs valid, prepare to send data back to MainActivity
            val resultIntent = Intent()
            resultIntent.putExtra("title", title)
            resultIntent.putExtra("artist", artist)
            resultIntent.putExtra("rating", rating)
            resultIntent.putExtra("comment", comment)
            setResult(Activity.RESULT_OK, resultIntent)
            finish() // Close screen and return to MainActivity
        }
    }
}
