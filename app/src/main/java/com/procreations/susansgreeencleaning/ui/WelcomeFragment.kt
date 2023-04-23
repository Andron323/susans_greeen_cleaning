package com.procreations.susansgreeencleaning.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.procreations.susansgreeencleaning.R
import com.procreations.susansgreeencleaning.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeBinding

    private lateinit var zipArray:List<Int>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        loadZipCods()
        setupUI()
        return binding.root
    }

    private fun loadZipCods() {

        zipArray = listOf(
            98004,
            98039,
            98033,
            98034,
            98028,
            98011,
            98072,
            98021,
            98012,
            98107,
            98103,
            98117,
            98105,
            98115,
            98125,
            98133,
            98155,
            98177,
            98028,
            98043,
            98020,
            98036,
            98037,
            98134,
            98118,
            98108,
            98106,
            98168,
            98146,
            98136,
            98126,
            98116,
            98040,
            98199,
            98119,
            98109,
            98102,
            98112,
            98122,
            98144
        )
    }

    @SuppressLint("SetTextI18n")
    private fun setupUI() {
        binding.apply {
            editZipCodLayout.visibility = View.GONE
            secondaryText.visibility = View.VISIBLE
            zipCodeBtn.text = "Zip Code"
        }

        binding.apply {
            zipCodeBtn.setOnClickListener {
                if (zipCodeBtn.text.toString().contains("Zip Code")){
                    editZipCod.setText("")
                    zipCodeBtn.text = "Ok"
                    editZipCodLayout.visibility = View.VISIBLE
                    secondaryText.visibility = View.INVISIBLE
                }else{
                    if (
                        try {
                            println(" ZIPID ${editZipCod.text}")
                            isContains(editZipCod.text.toString().toInt())
                        }catch (e:Exception){
//                            TODO need to add error alert of incorrect input user data
                            false
                        }
                    )
                        findNavController().navigate(R.id.action_welcomeFragment_to_homeFragment)
                    else
                        findNavController().navigate(R.id.action_welcomeFragment_to_sorryFragment)

                }
            }
        }
    }

    private fun isContains(userZipCode:Int):Boolean {
        return zipArray.contains(userZipCode)
    }
}