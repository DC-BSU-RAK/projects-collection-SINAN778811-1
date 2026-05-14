package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment

class HistoryFragment : Fragment(R.layout.fragment_history) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val historyContainer =
            view.findViewById<LinearLayout>(R.id.historyContainer)

        for (note in HistoryData.notes) {

            val textView = TextView(requireContext())

            textView.text = note
            textView.textSize = 18f
            textView.setPadding(20, 20, 20, 20)

            historyContainer.addView(textView)
        }
    }
}