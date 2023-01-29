package com.example.android11lesson8dz.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.android11lesson8dz.R
import com.example.android11lesson8dz.databinding.FragmentAddCinemaBinding
import com.example.android11lesson8dz.databinding.FragmentAddProgramBinding

class AddProgramFragment : Fragment() {
    private var binding: FragmentAddProgramBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddProgramBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClick()
    }

    private fun onClick() {
        binding?.btnInput3?.setOnClickListener {
            val bundle2 = Bundle()
            bundle2.putString("cat2", binding?.etText3?.text.toString())
            findNavController().navigate(
                R.id.action_addProgramFragment_to_PROGRAMMING_LANGUAGESFragment,
                bundle2
            )
        }
    }
}