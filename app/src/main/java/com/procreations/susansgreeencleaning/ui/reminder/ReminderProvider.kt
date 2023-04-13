package com.procreations.susansgreeencleaning.ui.reminder

import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.procreations.susansgreeencleaning.R
import com.procreations.susansgreeencleaning.model.AboutUs
import com.procreations.susansgreeencleaning.model.Contact
import com.procreations.susansgreeencleaning.model.Schedule
import com.procreations.susansgreeencleaning.ui.home.adapters.AboutUsAdapter
import com.procreations.susansgreeencleaning.ui.home.adapters.ContactsAdapter

class ReminderProvider(var controller: ReminderFragment) {
    private var presenter: ReminderPresenter? = null

    private var scheduleList: ArrayList<Schedule> = ArrayList()

    init {
        presenter = ReminderPresenter(controller)
        setData()
        initTargets()
        initAdapterSchedule()
    }

    private fun setData() {

        scheduleList.apply {
            add(
                Schedule(
                    null,
                    R.drawable.bucket,
                    "General cleanig",
                    "Cleaning and organizing is a practice not a project",
                    "5:09 PM",
                    ""
                )
            )
            add(
                Schedule(
                    null,
                    R.drawable.sponge,
                    "Standart cleanig",
                    "Cleanliness makes it easier to see the details",
                    "6:09 PM",
                    ""
                )
            )
            add(
                Schedule(
                    null,
                    R.drawable.window,
                    "Window cleanig",
                    "Cleaning and organizing is a practice not a project",
                    "7:12 PM",
                    ""
                )
            )
        }
    }

    private fun initAdapterSchedule() {
        presenter?.apply {
            rvSchedule.apply {
                layoutManager =
                    LinearLayoutManager(controller.context)
                adapter = ScheduleAdapter(scheduleList, controller)
            }
        }
    }

    private fun initTargets() {
        presenter?.apply {
            for (i in notification) {
                i.setOnClickListener {
                    setupNotification(notification.indexOf(i))
                }
            }

            floatingAddBtn.setOnClickListener {
                controller.findNavController().navigate(R.id.action_reminderFragment_to_calendarFragment)
            }
        }
    }

}