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
import com.example.android11lesson8dz.databinding.FragmentDetailBinding
import com.example.android11lesson8dz.databinding.FragmentDetailt2Binding

class DetailCinemaFragment : Fragment() {


    private lateinit var binding: FragmentDetailt2Binding
    private var catModel: CatModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailt2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnBack2.setOnClickListener {
            findNavController().navigateUp()
        }
        getData()
    }

    private fun getData() {
        val argument = arguments
        if (argument != null) {
            catModel = argument.getSerializable("key1") as CatModel?
            binding.imageDetailCinema.let {
                it.context.let { it1 ->
                    Glide.with(it1).load(catModel?.image).into(binding.imageDetailCinema)
                }
            }
            binding.txtNameDetailCinema.text = catModel?.name

        }
    }
}
