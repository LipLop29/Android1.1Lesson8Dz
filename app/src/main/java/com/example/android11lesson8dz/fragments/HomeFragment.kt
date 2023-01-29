package com.example.android11lesson8dz.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.android11lesson8dz.R
import com.example.android11lesson8dz.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var binding: FragmentHomeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.btnCats?.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_catFragment)
        }
        binding?.btnCinema?.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_cinematFragment)
        }
        binding?.btnProgram?.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_PROGRAMMING_LANGUAGESFragment)
        }

    }
}