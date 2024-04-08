package com.binar.challenge3.Adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.binar.challenge3.R

class Adapter2(private var listOfWords: List<String>) :
    RecyclerView.Adapter<Adapter2.WordViewHolder>() {
    inner class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val alphabetTV: TextView = itemView.findViewById(R.id.hurufTV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter2.WordViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item_word, parent, false)
        return WordViewHolder(view)
    }

    override fun onBindViewHolder(holder: Adapter2.WordViewHolder, position: Int) {
        holder.alphabetTV.text = listOfWords[position].toString()

        holder.itemView.setOnClickListener {
            // do an intent to search the word in google
            val intent = Intent().apply {
                action = Intent.ACTION_WEB_SEARCH
                putExtra("query", listOfWords[position])
            }
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listOfWords.size
    }

}

