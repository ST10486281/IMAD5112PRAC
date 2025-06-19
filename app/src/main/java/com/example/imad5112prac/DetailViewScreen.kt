package com.example.imad5112prac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DetailViewScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_view_screen)

        val show_songs = findViewById<Button>(R.id.show_songs)
        val show_average_rating = findViewById<Button>(R.id.show_average_rating)
        val return_to_main_screen = findViewById<Button>(R.id.return_to_main_screen)
        val results = findViewById<TextView>(R.id.results)

        // Receive data from MainActivity
        val songTitles = intent.getSerializableExtra("songTitles") as Array<String?>
        val artistNames = intent.getSerializableExtra("artistNames") as Array<String?>
        val ratingsArray = intent.getIntArrayExtra("ratings") ?: IntArray(0)
        val comments = intent.getSerializableExtra("comments") as Array<String?>
        val songCount = intent.getIntExtra("songCount", 0)

        show_songs.setOnClickListener {
            var displayText = ""
            for (i in 0 until songCount) {
                displayText += "Song ${i+1}:\n"
                displayText += "Title: ${songTitles[i]}\n"
                displayText += "Artist: ${artistNames[i]}\n"
                displayText += "Rating: ${ratingsArray[i]}\n"
                displayText += "Comments: ${comments[i]}\n\n"
            }
            results.text = displayText
        }

        show_average_rating.setOnClickListener {
            if (songCount == 0) {
                results.text = "No songs to calculate average."
                return@setOnClickListener
            }

            var total = 0
            for (i in 0 until songCount) {
                total += ratingsArray[i]
            }
            val average = total.toDouble() / songCount
            results.text = "Average Rating: %.2f".format(average)
        }

        return_to_main_screen.setOnClickListener {
            finish()
        }
    }
}
