package com.procreations.susansgreeencleaning.ui.calendar

import android.view.View
import android.widget.CalendarView
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

class CalendarPresenter(var controller: CalendarFragment) {

    lateinit var calendarView: CalendarView

    lateinit var setDate: EditText
    lateinit var setTime: EditText
    lateinit var repeat: EditText
    lateinit var newReminder: EditText

    lateinit var saveTxt: TextView
    lateinit var cancelTxt: TextView



    init {
        initUI()
    }

    private fun initUI() {

        calendarView = controller.binding.calendarView
        setDate = controller.binding.setDate
        setTime = controller.binding.setTime
        repeat = controller.binding.repeat
        newReminder = controller.binding.newReminder
        saveTxt = controller.binding.saveTxt
        cancelTxt = controller.binding.cancelTxt
    }

}