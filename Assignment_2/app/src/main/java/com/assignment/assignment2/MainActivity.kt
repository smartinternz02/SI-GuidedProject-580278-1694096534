package com.assignment.assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.Random

class MainActivity : AppCompatActivity() {
    private lateinit var resultTextView: TextView
    private lateinit var rollButton: Button
    private lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)
        rollButton = findViewById(R.id.rollButton)
        diceImage = findViewById(R.id.diceImage)

        rollButton.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        val images = intArrayOf(
            R.drawable.dice1,
            R.drawable.dice2,
            R.drawable.dice3,
            R.drawable.dice4,
            R.drawable.dice5,
            R.drawable.dice6
        )
        val random = Random()
        val randomNumber = random.nextInt(6) + 1

        val resultText = "You rolled a $randomNumber"
        resultTextView.text = resultText
        diceImage.setImageResource(images[randomNumber-1])

    }
}