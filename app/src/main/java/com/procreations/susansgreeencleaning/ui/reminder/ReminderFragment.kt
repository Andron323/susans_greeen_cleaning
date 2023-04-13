package com.procreations.susansgreeencleaning.ui.reminder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.procreations.susansgreeencleaning.R
import com.procreations.susansgreeencleaning.databinding.FragmentReminderBinding
import com.procreations.susansgreeencleaning.ui.home.HomeProvider

class ReminderFragment : Fragment() {
    lateinit var binding: FragmentReminderBinding
    var provider: ReminderProvider? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_reminder, container, false)
        binding = FragmentReminderBinding.inflate(inflater,container,false)

        provider = ReminderProvider(this)

        return binding.root
    }
}