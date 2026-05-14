package com.example.foodcalculator

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.foodrecommentationcalculator.R

class MainActivity : AppCompatActivity() {

    lateinit var result: TextView

    var selectedMood = ""
    var selectedFood = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // RESULT TEXTVIEW
        result = findViewById(R.id.result)

        // MOOD BUTTONS
        val happy = findViewById<Button>(R.id.happy)
        val sad = findViewById<Button>(R.id.sad)
        val tired = findViewById<Button>(R.id.tired)

        // FOOD TYPE BUTTONS
        val italian = findViewById<Button>(R.id.italian)
        val indian = findViewById<Button>(R.id.indian)
        val fastfood = findViewById<Button>(R.id.fastfood)

        // CALCULATE BUTTON
        val calculate = findViewById<Button>(R.id.calculate)

        // INFO BUTTON
        val info = findViewById<Button>(R.id.info)

        // MOOD SELECTION
        happy.setOnClickListener {
            selectedMood = "Happy"
        }

        sad.setOnClickListener {
            selectedMood = "Sad"
        }

        tired.setOnClickListener {
            selectedMood = "Tired"
        }

        // FOOD TYPE SELECTION
        italian.setOnClickListener {
            selectedFood = "Italian"
        }

        indian.setOnClickListener {
            selectedFood = "Indian"
        }

        fastfood.setOnClickListener {
            selectedFood = "Fast Food"
        }

        // CALCULATE RESULT
        calculate.setOnClickListener {

            val recommendation = when {

                selectedMood == "Happy" && selectedFood == "Italian" ->
                    "Recommended Food: Pizza 🍕"

                selectedMood == "Happy" && selectedFood == "Indian" ->
                    "Recommended Food: Biryani 🍛"

                selectedMood == "Happy" && selectedFood == "Fast Food" ->
                    "Recommended Food: Burger 🍔"

                selectedMood == "Sad" && selectedFood == "Italian" ->
                    "Recommended Food: Pasta 🍝"

                selectedMood == "Sad" && selectedFood == "Indian" ->
                    "Recommended Food: Butter Chicken 🍗"

                selectedMood == "Sad" && selectedFood == "Fast Food" ->
                    "Recommended Food: Fries 🍟"

                selectedMood == "Tired" && selectedFood == "Italian" ->
                    "Recommended Food: Lasagna 🧀"

                selectedMood == "Tired" && selectedFood == "Indian" ->
                    "Recommended Food: Dosa 🥞"

                selectedMood == "Tired" && selectedFood == "Fast Food" ->
                    "Recommended Food: Wrap 🌯"

                else ->
                    "Please Select Mood and Food Type"
            }

            result.text = recommendation
        }

        // INFO BUTTON CLICK
        info.setOnClickListener {

            val builder = AlertDialog.Builder(this)

            builder.setTitle("About This App")

            builder.setMessage(
                "Food Calculator App 🍔\n\n" +
                        "This app recommends food based on your mood and selected food type.\n\n" +
                        "Created using Android Studio and Kotlin."
            )

            builder.setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }

            builder.show()
        }
    }
}