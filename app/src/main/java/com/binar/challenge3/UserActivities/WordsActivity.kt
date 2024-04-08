package com.binar.challenge3.UserActivities

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.binar.challenge3.Adapters.Adapter2
import com.binar.challenge3.R
import com.google.android.material.textview.MaterialTextView

class WordsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_word)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val BackButton: ImageView = findViewById(R.id.backButton)
        BackButton.setOnClickListener {
            finish()
        }

        val recyclerView: RecyclerView = findViewById(R.id.usedRecyclerView2)
        recyclerView.layoutManager =
            androidx.recyclerview.widget.LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        val words: List<String> = intent.getStringArrayListExtra("word") as List<String>
        val adapter = Adapter2(words)
        recyclerView.adapter = adapter

        val leadingTV: MaterialTextView = findViewById(R.id.leadingTV)
        leadingTV.text = "Words that start with ${words[0].substring(0, 1).toUpperCase()}"
    }
}