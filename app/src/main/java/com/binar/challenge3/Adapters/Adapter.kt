package com.binar.challenge3.Adapters

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.binar.challenge3.Models.Model
import com.binar.challenge3.R
import com.binar.challenge3.UserActivities.WordsActivity

class Adapter(
    private var usedList: List<Model>
) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val alphabetTV: TextView = itemView.findViewById(R.id.hurufTV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item_word, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return usedList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.alphabetTV.text = usedList[position].id.toString()

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, WordsActivity::class.java)
            intent.putStringArrayListExtra(
                "word",
                ArrayList(usedList[position].listOfWords)
            )
            holder.itemView.context.startActivity(intent)
        }
    }
}