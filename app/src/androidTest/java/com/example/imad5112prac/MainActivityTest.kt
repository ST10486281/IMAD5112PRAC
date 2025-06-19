package com.example.imad5112prac

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import android.widget.Button
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Test
    fun testButtonsExist() {
        val scenario = ActivityScenario.launch(MainActivity::class.java)
        scenario.onActivity { activity ->
            assertNotNull(activity.findViewById<Button>(R.id.add_to_playlist))
            assertNotNull(activity.findViewById<Button>(R.id.view_details))
            assertNotNull(activity.findViewById<Button>(R.id.exit_app))
        }
    }
}
