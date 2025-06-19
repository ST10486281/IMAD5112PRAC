package com.example.imad5112prac

import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import android.widget.Button
import android.widget.TextView
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DetailViewScreenTest {

    @Test
    fun testDetailButtonsExist() {
        // Create Intent with dummy extras to prevent crash
        val intent = Intent(ApplicationProvider.getApplicationContext(), DetailViewScreen::class.java)
        intent.putExtra("songTitles", arrayOfNulls<String>(4))
        intent.putExtra("artistNames", arrayOfNulls<String>(4))
        intent.putExtra("ratings", intArrayOf(0, 0, 0, 0))
        intent.putExtra("comments", arrayOfNulls<String>(4))
        intent.putExtra("songCount", 0)

        // Launch activity with prepared Intent
        val scenario = ActivityScenario.launch<DetailViewScreen>(intent)

        scenario.onActivity { activity ->
            assertNotNull(activity.findViewById<Button>(R.id.show_songs))
            assertNotNull(activity.findViewById<Button>(R.id.show_average_rating))
            assertNotNull(activity.findViewById<Button>(R.id.return_to_main_screen))
            assertNotNull(activity.findViewById<TextView>(R.id.results))
        }
    }
}
