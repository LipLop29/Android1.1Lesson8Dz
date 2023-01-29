package com.example.android11lesson8dz.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.android11lesson8dz.R
import com.example.android11lesson8dz.databinding.FragmentAddCatBinding

class AddCatFragment : Fragment() {
    private var binding: FragmentAddCatBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddCatBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClick()
    }

    private fun onClick() {
        binding?.btnInput?.setOnClickListener {
            val bundle2 = Bundle()
            bundle2.putString("cat2", binding?.etText?.text.toString())
            findNavController().navigate(R.id.action_addCatFragment_to_catFragment, bundle2)
        }
    }

}