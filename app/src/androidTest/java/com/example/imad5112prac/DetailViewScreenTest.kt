package com.example.imad5112prac

import androidx.test.core.app.ActivityScenario
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
        val scenario = ActivityScenario.launch(DetailViewScreen::class.java)
        scenario.onActivity { activity ->
            assertNotNull(activity.findViewById<Button>(R.id.show_songs))
            assertNotNull(activity.findViewById<Button>(R.id.show_average_rating))
            assertNotNull(activity.findViewById<Button>(R.id.return_to_main_screen))
            assertNotNull(activity.findViewById<TextView>(R.id.results))
        }
    }
}
