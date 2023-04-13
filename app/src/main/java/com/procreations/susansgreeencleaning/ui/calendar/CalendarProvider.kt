package com.procreations.susansgreeencleaning.ui.calendar

import androidx.recyclerview.widget.LinearLayoutManager
import com.procreations.susansgreeencleaning.R
import com.procreations.susansgreeencleaning.model.AboutUs
import com.procreations.susansgreeencleaning.model.Contact
import com.procreations.susansgreeencleaning.ui.home.adapters.AboutUsAdapter
import com.procreations.susansgreeencleaning.ui.home.adapters.ContactsAdapter

class CalendarProvider(var controller: CalendarFragment) {
    private var presenter: CalendarPresenter? = null

    init {
        presenter = CalendarPresenter(controller)

        initTargets()
    }

    private fun initTargets() {
        presenter?.apply {

            saveTxt.setOnClickListener {

            }
            cancelTxt.setOnClickListener {

            }
        }
    }

}