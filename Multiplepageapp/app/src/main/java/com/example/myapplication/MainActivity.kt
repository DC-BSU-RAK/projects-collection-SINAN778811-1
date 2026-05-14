package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        // OPEN MOOD PAGE FIRST
        replaceFragment(MoodFragment())

        // BUTTON CLICK EVENTS
        bottomNav.setOnItemSelectedListener {

            when (it.itemId) {

                R.id.nav_mood -> {
                    replaceFragment(MoodFragment())
                    true
                }

                R.id.nav_journal -> {
                    replaceFragment(JournalFragment())
                    true
                }

                R.id.nav_history -> {
                    replaceFragment(HistoryFragment())
                    true
                }

                else -> false
            }
        }
    }

    // FUNCTION TO CHANGE FRAGMENTS

    private fun replaceFragment(fragment: Fragment) {

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}