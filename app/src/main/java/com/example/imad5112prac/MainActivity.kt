package com.example.imad5112prac

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    // Declare parallel arrays to store song details, maximum 4 songs
    private val songTitles = arrayOfNulls<String>(4)
    private val artistNames = arrayOfNulls<String>(4)
    private val ratings = IntArray(4)
    private val comments = arrayOfNulls<String>(4)
    private var songCount = 0 // Keeps track of how many songs have been added

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get button references
        val add_to_playlist = findViewById<Button>(R.id.add_to_playlist)
        val view_details = findViewById<Button>(R.id.view_details)
        val exit_app = findViewById<Button>(R.id.exit_app)

        // When user clicks "Add to Playlist", open AddSongScreen
        add_to_playlist.setOnClickListener {
            val intent = Intent(this, AddSongScreen::class.java)
            // Pass songCount to AddSongScreen so it knows if list is full
            intent.putExtra("songCount", songCount)
            startActivityForResult(intent, 1)
        }

        // When user clicks "View Details", open DetailViewScreen
        view_details.setOnClickListener {
            val intent = Intent(this, DetailViewScreen::class.java)
            // Pass arrays and songCount to DetailViewScreen
            intent.putExtra("songTitles", songTitles)
            intent.putExtra("artistNames", artistNames)
            intent.putExtra("ratings", ratings)
            intent.putExtra("comments", comments)
            intent.putExtra("songCount", songCount)
            startActivity(intent)
        }

        // When user clicks "Exit App", close the app
        exit_app.setOnClickListener {
            finish() // closes MainActivity
        }
    }

    // Receive data back from AddSongScreen after adding a new song
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 && resultCode == Activity.RESULT_OK && data != null) {
            // Retrieve song data from Intent
            val title = data.getStringExtra("title")
            val artist = data.getStringExtra("artist")
            val rating = data.getIntExtra("rating", 0)
            val comment = data.getStringExtra("comment")

            // Store data into arrays at current songCount position
            songTitles[songCount] = title
            artistNames[songCount] = artist
            ratings[songCount] = rating
            comments[songCount] = comment

            songCount++ // increment song count after successful add

            Toast.makeText(this, "Song added successfully!", Toast.LENGTH_SHORT).show()
        }
    }
}
