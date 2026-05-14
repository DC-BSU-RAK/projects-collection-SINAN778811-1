package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class JournalFragment : Fragment(R.layout.fragment_journal) {

    private lateinit var historyContainer: LinearLayout

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // BACK BUTTON

        val backButton = view.findViewById<ImageView>(R.id.btnBack)

        backButton.setOnClickListener {

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, MoodFragment())
                .commit()
        }

        // HISTORY CONTAINER

        historyContainer =
            view.findViewById(R.id.historyContainer)

        // LOAD EXISTING NOTES

        refreshHistory()

        // EDIT TEXT

        val editText =
            view.findViewById<EditText>(R.id.editJournal)

        // SAVE BUTTON

        val saveButton =
            view.findViewById<Button>(R.id.btnSave)

        saveButton.setOnClickListener {

            val note = editText.text.toString()

            if (note.isNotEmpty()) {

                // SAVE NOTE

                HistoryData.notes.add(0, note)

                // REFRESH HISTORY

                refreshHistory()

                Toast.makeText(
                    requireContext(),
                    "Saved Successfully",
                    Toast.LENGTH_SHORT
                ).show()

                editText.text.clear()

            } else {

                Toast.makeText(
                    requireContext(),
                    "Write something first",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    // REFRESH HISTORY SECTION

    private fun refreshHistory() {

        historyContainer.removeAllViews()

        for (note in HistoryData.notes) {

            val item = TextView(requireContext())

            item.text = note
            item.textSize = 18f
            item.setPadding(20, 20, 20, 20)

            historyContainer.addView(item)
        }
    }
}