package com.marshanda.pertemuan9restapi.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.marshanda.pertemuan9restapi.R
import com.marshanda.pertemuan9restapi.adapter.HomeAdapter
import com.marshanda.pertemuan9restapi.databinding.FragmentHomeBinding
import com.marshanda.pertemuan9restapi.viewmodel.ViewModelMahasiswa
class HomeFragment : Fragment() {
    lateinit var binding : FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnMovetoTambah.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_tambahFragment)
        }

        val viewModel = ViewModelProvider(this).get(ViewModelMahasiswa::class.java)
        viewModel.getDataMahasiswa().observe(viewLifecycleOwner){
            if(it != null){
                binding.rvUser.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
                val adapter = HomeAdapter(it)
                binding.rvUser.adapter = adapter
            }else {
                binding.rvUser.visibility = View.GONE
            }
        }
        viewModel.showDataMahasiswa()
    }
}