package com.github.odaridavid.sharedpreference

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences(
            "com.github.odaridavid.sharedpreference.AppPreferences",
            Context.MODE_PRIVATE
        )

        val saveHighScoreButton = findViewById<Button>(R.id.saveHighestScoreButton)
        val displayHighScore = findViewById<TextView>(R.id.displayHighestScoreTextView)
        val highScoreEditText = findViewById<EditText>(R.id.highestScoreEditText)

        // Read from Shared Preferences
        val highestScoreValue = sharedPreferences.getInt(HIGH_SCORE_KEY, -1)
        displayHighScore.text = "Your current high score is $highestScoreValue"

        // Write to Shared Preferences
        saveHighScoreButton.setOnClickListener {
            val highestScore = highScoreEditText.text.toString().toInt()
            sharedPreferences
                .edit()
                .putInt(HIGH_SCORE_KEY,highestScore)
                .apply()
        }
    }

    companion object{
        private const val HIGH_SCORE_KEY = "HIGH_SCORE_KEY"
    }
}
