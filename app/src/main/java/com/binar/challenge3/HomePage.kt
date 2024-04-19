package com.binar.challenge3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.binar.challenge3.Adapters.Adapter
import com.binar.challenge3.databinding.FragmentHomePageBinding

class HomePage : Fragment() {
    private lateinit var binding: FragmentHomePageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomePageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listOfAlphabets = ('A'..'Z').map { it.toString() }

        val recyclerView: RecyclerView = view.findViewById(R.id.usedRecyclerView)
        val adapter = Adapter(listOfAlphabets)
        recyclerView.adapter = adapter
        recyclerView.layoutManager =
            androidx.recyclerview.widget.LinearLayoutManager(context, RecyclerView.VERTICAL, false)
//        recyclerView.layoutManager = androidx.recyclerview.widget.GridLayoutManager(context, 2)
    }
}