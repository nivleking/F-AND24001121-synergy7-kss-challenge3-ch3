package com.binar.challenge3.UserActivities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.binar.challenge3.Adapters.Adapter2
import com.binar.challenge3.R
import com.binar.challenge3.databinding.FragmentWordPageBinding

class WordPage : Fragment() {
    private lateinit var binding: FragmentWordPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWordPageBinding.inflate(inflater, container, false)

        val word = arguments?.getStringArrayList("word")
        val recyclerView = binding.usedRecyclerView2
        val adapter = Adapter2(word ?: arrayListOf())
        recyclerView.adapter = adapter
        recyclerView.layoutManager =
            androidx.recyclerview.widget.LinearLayoutManager(context, RecyclerView.VERTICAL, false)
//        recyclerView.layoutManager = androidx.recyclerview.widget.GridLayoutManager(context, 1)
        val toolbar = binding.topAppBar
        toolbar.setNavigationOnClickListener {
            it.findNavController().navigate(R.id.action_wordPage_to_homePage)
        }
        toolbar.title = "Words that start with ${word?.get(0)?.get(0)}"

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}