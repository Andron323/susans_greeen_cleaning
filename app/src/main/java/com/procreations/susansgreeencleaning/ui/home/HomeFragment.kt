package com.procreations.susansgreeencleaning.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.procreations.susansgreeencleaning.databinding.FragmentHomeBinding
import com.procreations.susansgreeencleaning.databinding.FragmentSorryBinding
import com.procreations.susansgreeencleaning.databinding.FragmentWelcomeBinding

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    var provider: HomeProvider? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false)
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        provider = HomeProvider(this)

        return binding.root
    }

}