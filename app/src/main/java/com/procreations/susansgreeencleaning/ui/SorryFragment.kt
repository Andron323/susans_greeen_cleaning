package com.procreations.susansgreeencleaning.ui

import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.procreations.susansgreeencleaning.R
import com.procreations.susansgreeencleaning.databinding.FragmentSorryBinding


class SorryFragment : Fragment() {
    private lateinit var binding: FragmentSorryBinding

//    private var image: ImageView? = null
//    private var animation: AnimatedVectorDrawable? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_sorry, container, false)
        binding = FragmentSorryBinding.inflate(inflater, container, false)
        setupUI()
        return binding.root
    }

    private fun setupUI() {
        binding.okayBtn.setOnClickListener {
            findNavController().navigate(R.id.action_sorryFragment_to_homeFragment)
        }

        rotateAnimStart(binding.boarder)
        blinkAnimStart(binding.starsTop)
        blinkAnimStart(binding.starsBottom)

    }

    private fun rotateAnimStart(image: ImageView) {
        val animation: AnimatedVectorDrawable
        image.setImageResource(R.drawable.board_anim)

        val drawable = image.drawable
        if (drawable is AnimatedVectorDrawable) {
            animation = drawable
            animation.start()
        }
    }

    private fun blinkAnimStart(image:ImageView) {
        val animation: AnimatedVectorDrawable
        image.setImageResource(R.drawable.stars_anim)

        val drawable = image.drawable
        if (drawable is AnimatedVectorDrawable) {
            animation = drawable
            animation.start()
        }
    }

}