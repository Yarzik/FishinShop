package com.bam.shopproject.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bam.shopproject.databinding.FragmentBootsAboutBinding
import com.squareup.picasso.Picasso


class SpinAboutFragment : Fragment() {

    lateinit var binding: FragmentBootsAboutBinding
    lateinit var viewModel: SpinViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBootsAboutBinding.inflate(inflater)
        viewModel = ViewModelProvider(requireActivity())[SpinViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = arguments?.getInt("ID")
        if (id != -1){
            id?.let {
                viewModel.getById(id)
            }
        }

        viewModel.selectedBoots.observe(requireActivity()){
            if (it != null){
                binding.boots = it
                Picasso.get().load(it.img).into(binding.imageView2)
            }
        }

    }


}