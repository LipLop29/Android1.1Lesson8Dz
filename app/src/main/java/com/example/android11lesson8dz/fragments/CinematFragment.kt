package com.example.android11lesson8dz.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android11lesson8dz.R
import com.example.android11lesson8dz.`interface`.OnItemTextListener
import com.example.android11lesson8dz.adapter.CinemaAdapter
import com.example.android11lesson8dz.data.CatModel
import com.example.android11lesson8dz.databinding.FragmentCinematBinding
import com.example.android11lesson8dz.repository.CatsRepository
import com.example.android11lesson8dz.repository.CinemaRepository

class CinematFragment : Fragment(), OnItemTextListener {
    private var binding: FragmentCinematBinding? = null
    private val listCinema = mutableListOf<CatModel>()
    private val repository = CinemaRepository()
    private val catAdapter = CinemaAdapter(listCinema, this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCinematBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.recyclerCinema?.layoutManager = LinearLayoutManager(
            context, RecyclerView.VERTICAL, false
        )
        listCinema.addAll(repository.getListOfCinema())
        binding?.recyclerCinema?.adapter = catAdapter

        binding?.btnBackCinema?.setOnClickListener {
            findNavController().navigate(R.id.action_cinematFragment_to_addCinemaFragment)
        }
        getData()
    }

    private fun getData() {
        val bundle = arguments
        if (arguments != null) {
            val text = bundle?.getString("cat2")
            listCinema.add(CatModel(listCinema.toString(), text.toString()))
        }
    }

    override fun onItemClick(model: CatModel) {
        val bundle1 = Bundle()
        bundle1.putSerializable("key1", model)
        findNavController().navigate(R.id.action_cinematFragment_to_detailCinemaFragment, bundle1)
            .toString()
    }

    override fun onLongClick(model: CatModel): Boolean {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}