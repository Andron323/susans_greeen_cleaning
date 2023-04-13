package com.procreations.susansgreeencleaning.ui.calendar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.procreations.susansgreeencleaning.databinding.FragmentCalendarBinding

class CalendarFragment : Fragment() {

    lateinit var binding: FragmentCalendarBinding
    lateinit var provider: CalendarProvider

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_calendar, container, false)
        binding = FragmentCalendarBinding.inflate(inflater,container,false)

        provider = CalendarProvider(this)
//        binding.scrollView.requestChildFocus(binding.setTime,binding.setDate)
//        val scrollTo: Int = (binding.setTime.getParent().getParent() as View).top + binding.setDate.getTop()
//        binding.scrollView.smoothScrollTo(0, scrollTo)
        return binding.root
    }

}