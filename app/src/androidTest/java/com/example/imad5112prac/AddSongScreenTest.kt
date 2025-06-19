package com.example.imad5112prac

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import android.widget.EditText
import android.widget.Button
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AddSongScreenTest {

    @Test
    fun testInputFieldsExist() {
        val scenario = ActivityScenario.launch(AddSongScreen::class.java)
        scenario.onActivity { activity ->
            assertNotNull(activity.findViewById<EditText>(R.id.song_title))
            assertNotNull(activity.findViewById<EditText>(R.id.artist_name))
            assertNotNull(activity.findViewById<EditText>(R.id.rating_1_to_5))
            assertNotNull(activity.findViewById<EditText>(R.id.comments))
            assertNotNull(activity.findViewById<Button>(R.id.add_song))
        }
    }
}
