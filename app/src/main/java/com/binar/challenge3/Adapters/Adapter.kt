package com.binar.challenge3.Adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.binar.challenge3.R

class Adapter(
    private var usedList: List<String>,
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
        val listOfWords = mapOf(
            "A" to listOf("Apple", "Ant", "Ape"),
            "B" to listOf("Banana", "Bat", "Bee"),
            "C" to listOf("Cat", "Car", "Cow"),
            "D" to listOf("Dog", "Duck", "Deer"),
            "E" to listOf("Elephant", "Eagle", "Eel"),
            "F" to listOf("Fox", "Fish", "Frog"),
            "G" to listOf("Goat", "Giraffe", "Gorilla"),
            "H" to listOf("Horse", "Hippo", "Hedgehog"),
            "I" to listOf("Iguana", "Impala", "Insect"),
            "J" to listOf("Jaguar", "Jellyfish", "Jackal"),
            "K" to listOf("Kangaroo", "Koala", "Kookaburra"),
            "L" to listOf("Lion", "Lemur", "Llama"),
            "M" to listOf("Monkey", "Moose", "Mole"),
            "N" to listOf("Narwhal", "Newt", "Nightingale"),
            "O" to listOf("Owl", "Otter", "Ox"),
            "P" to listOf("Penguin", "Panda", "Parrot"),
            "Q" to listOf("Quail", "Quokka", "Quetzal"),
            "R" to listOf("Rabbit", "Raccoon", "Reindeer"),
            "S" to listOf("Squirrel", "Seal", "Shark"),
            "T" to listOf("Tiger", "Turtle", "Toucan"),
            "U" to listOf("Uakari", "Umbrellabird", "Urial"),
            "V" to listOf("Vulture", "Viper", "Vole"),
            "W" to listOf("Wolf", "Whale", "Wombat"),
            "X" to listOf("Xerus", "X-ray Tetra", "Xenops"),
            "Y" to listOf("Yak", "Yellowjacket", "Yabby"),
            "Z" to listOf("Zebra", "Zebu", "Zonkey")
        )

        holder.alphabetTV.text = usedList[position]

        //homepage
        holder.itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putStringArrayList(
                "word",
                ArrayList(listOfWords[usedList[position]] ?: listOf())
            )

            it.findNavController().navigate(R.id.action_homePage_to_wordPage, bundle)

//            holder.itemView.setOnClickListener {
//                val action = HomePageDirections.actionHomePageToWordPage(
//                    ArrayList(listOfWords[usedList[position]] ?: listOf())
//                )
//                it.findNavController().navigate(action)
//            }
        }
    }
}