package com.example.android11lesson8dz.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android11lesson8dz.R
import com.example.android11lesson8dz.`interface`.OnItemTextListener
import com.example.android11lesson8dz.adapter.CatAdapter
import com.example.android11lesson8dz.data.CatModel
import com.example.android11lesson8dz.databinding.FragmentCatBinding
import com.example.android11lesson8dz.repository.CatsRepository

class CatFragment : Fragment(), OnItemTextListener {
    private var binding: FragmentCatBinding? = null
    private var listCat = mutableListOf<CatModel>()
    private val repository = CatsRepository()
    private val catAdapter = CatAdapter(listCat, this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCatBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.recycler?.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        listCat.addAll(repository.getListOfCatHTP())
        binding?.recycler?.adapter = catAdapter

        binding?.btnBack?.setOnClickListener {
            findNavController().navigate(R.id.action_catFragment_to_addCatFragment)
        }
        getData()
    }

    private fun getData() {
        val bundle = arguments
        if (arguments != null) {
            val text = bundle?.getString("cat2")
            listCat.add(CatModel(listCat.toString(), text.toString()))
        }
    }


    override fun onItemClick(model: CatModel) {
        val bundle = Bundle()
        bundle.putSerializable("key", model)
        findNavController().navigate(R.id.action_catFragment_to_detailFragment, bundle)
            .toString()
    }

    override fun onLongClick(model: CatModel  ): Boolean {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}