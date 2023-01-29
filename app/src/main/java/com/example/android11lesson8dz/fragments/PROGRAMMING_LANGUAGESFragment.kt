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
import com.example.android11lesson8dz.adapter.ProgAdapter
import com.example.android11lesson8dz.data.CatModel
import com.example.android11lesson8dz.databinding.FragmentPROGRAMMINGLANGUAGESBinding
import com.example.android11lesson8dz.repository.ProgramRepository


class PROGRAMMING_LANGUAGESFragment : Fragment(), OnItemTextListener {
    private var binding: FragmentPROGRAMMINGLANGUAGESBinding? = null
    private val listCinema = mutableListOf<CatModel>()
    private val repository = ProgramRepository()
    private val catAdapter = ProgAdapter(listCinema, this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPROGRAMMINGLANGUAGESBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.recyclerProg?.layoutManager = LinearLayoutManager(
            context, RecyclerView.VERTICAL, false
        )
        listCinema.addAll(repository.getListOfCinema())
        binding?.recyclerProg?.adapter = catAdapter

        binding?.btnBackProg?.setOnClickListener {
            findNavController().navigate(R.id.action_PROGRAMMING_LANGUAGESFragment_to_addProgramFragment)
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

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    override fun onItemClick(model: CatModel) {
        val bundle = Bundle()
        bundle.putSerializable("key2", model)
        findNavController().navigate(
            R.id.action_PROGRAMMING_LANGUAGESFragment_to_deteilProgramFragment2,
            bundle
        )
            .toString()
    }

    override fun onLongClick(model: CatModel): Boolean {
        TODO("Not yet implemented")
    }
}