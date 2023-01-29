package com.example.android11lesson8dz.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.android11lesson8dz.R
import com.example.android11lesson8dz.databinding.FragmentAddCatBinding
import com.example.android11lesson8dz.databinding.FragmentAddCinemaBinding

class AddCinemaFragment : Fragment() {
    private var binding: FragmentAddCinemaBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddCinemaBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClick()
    }

    private fun onClick() {
        binding?.btnInput2?.setOnClickListener {
            val bundle2 = Bundle()
            bundle2.putString("cat2", binding?.etText2?.text.toString())
            findNavController().navigate(R.id.action_addCinemaFragment_to_cinematFragment, bundle2)
        }
    }
}