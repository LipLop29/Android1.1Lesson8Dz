package com.example.android11lesson8dz.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.android11lesson8dz.R
import com.example.android11lesson8dz.data.CatModel
import com.example.android11lesson8dz.databinding.FragmentDetailt2Binding
import com.example.android11lesson8dz.databinding.FragmentDeteilProgramBinding

class DeteilProgramFragment : Fragment() {

    private lateinit var binding: FragmentDeteilProgramBinding
    private var catModel: CatModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDeteilProgramBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnBack3.setOnClickListener {
            findNavController().navigateUp()
        }
        getData()
    }

    private fun getData() {
        val argument = arguments
        if (argument != null) {
            catModel = argument.getSerializable("key2") as CatModel?
            binding.imageDetailProgram.let {
                it.context.let { it1 ->
                    Glide.with(it1).load(catModel?.image).into(binding.imageDetailProgram)
                }
            }
            binding.txtNameDetailProgram.text = catModel?.name

        }
    }


}