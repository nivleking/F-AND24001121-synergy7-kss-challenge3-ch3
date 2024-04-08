package com.binar.challenge3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.binar.challenge3.Adapters.Adapter
import com.binar.challenge3.Models.Model

class MainActivity : AppCompatActivity() {
//    lateinit var recyclerView: RecyclerView
//    lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

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
        val usedList = mutableListOf<Model>()
        for ((key, value) in listOfWords) {
            usedList.add(Model(key, value))
        }

        val recyclerView: RecyclerView = findViewById(R.id.usedRecyclerView)
        val adapter = Adapter(usedList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager =
            androidx.recyclerview.widget.LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }
}