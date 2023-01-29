package com.example.android11lesson8dz.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.android11lesson8dz.data.CatModel
import com.example.android11lesson8dz.databinding.FragmentDetailBinding

@Suppress("DEPRECATION")
class DetailCatFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private var catModel: CatModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
        getData
    }

    private val getData: Unit
        get() {
            val argumentt = arguments
            if (argumentt != null) {
                catModel = argumentt.getSerializable("key") as CatModel?
                binding.imageDetail.let {
                    it.context.let { it2 ->
                        Glide.with(it2).load(catModel?.image).into(binding.imageDetail)
                    }
                }
                binding.txtNameDetail.text = catModel?.name
            }
        }
}