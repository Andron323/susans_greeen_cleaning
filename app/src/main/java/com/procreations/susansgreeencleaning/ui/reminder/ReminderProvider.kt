package com.procreations.susansgreeencleaning.ui.reminder

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.procreations.susansgreeencleaning.MainActivity
import com.procreations.susansgreeencleaning.R
import com.procreations.susansgreeencleaning.model.Schedule
import com.procreations.susansgreeencleaning.utils.SwipeHelper2
import java.lang.reflect.Type


class ReminderProvider(var controller: ReminderFragment) {
    private var presenter: ReminderPresenter? = null

    private var scheduleList: ArrayList<Schedule> = ArrayList()
    private var mainActivityContext = (controller.activity as MainActivity)

    init {
        presenter = ReminderPresenter(controller)
        setData()
        initTargets()
        setupSwipeDelete()
    }

    private fun setData() {

        val reminder = mainActivityContext.getSharedPreferences()?.getString("scheduleList",null)
        val gson = Gson()
        val type: Type = object : TypeToken<ArrayList<Schedule>>() {}.type

        if (reminder != null) {
            scheduleList = gson.fromJson<Any>(reminder, type) as ArrayList<Schedule>
            try {
                initAdapterSchedule()
            }catch (e:java.lang.Exception){
                println("ERROR_LIST $e")
            }
        }else{
//            add empty list alert
        }

//        scheduleList.apply {
//            add(
//                Schedule(
//                    null,
//                    R.drawable.bucket,
//                    "General cleanig",
//                    "Cleaning and organizing is a practice not a project",
//                    "5:09 PM",
//                    "",
//                    "",
//                    ""
//                )
//            )
//            add(
//                Schedule(
//                    null,
//                    R.drawable.sponge,
//                    "Standart cleanig",
//                    "Cleanliness makes it easier to see the details",
//                    "6:09 PM",
//                    "",
//                    "",
//                    ""
//                )
//            )
//            add(
//                Schedule(
//                    null,
//                    R.drawable.window,
//                    "Window cleanig",
//                    "Cleaning and organizing is a practice not a project",
//                    "7:12 PM",
//                    "",
//                    "",
//                    ""
//                )
//            )
//        }
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

            fabGeneral.setOnClickListener {
                val bundle = Bundle()
                bundle.putString("fabType", "fabGeneral")
                controller.findNavController().navigate(R.id.action_reminderFragment_to_calendarFragment,bundle)
            }
            fabStandart.setOnClickListener {
                val bundle = Bundle()
                bundle.putString("fabType", "fabStandart")
                controller.findNavController().navigate(R.id.action_reminderFragment_to_calendarFragment,bundle)
            }
        }
    }

    private fun setupSwipeDelete() {
        val itemTouchHelper = ItemTouchHelper(object : SwipeHelper2(presenter!!.rvSchedule) {
            override fun instantiateUnderlayButton(position: Int): List<UnderlayButton> {
                return listOf(
                    deleteButton(position)
                )
            }
        })
        itemTouchHelper.attachToRecyclerView(presenter!!.rvSchedule)

//        object : SwipeHelper(controller.context, presenter!!.rvSchedule, false) {
//            override fun instantiateUnderlayButton(viewHolder: RecyclerView.ViewHolder?,underlayButtons: MutableList<UnderlayButton>?) {
//
//                //adding first button
//                underlayButtons?.add(
//                    SwipeHelper.UnderlayButton("Archive", AppCompatResources.getDrawable(controller.requireContext(),R.drawable.google),
//                        Color.parseColor("#000000"), Color.parseColor("#ffffff"),
//
//                        UnderlayButtonClickListener { pos: Int ->
//                            deleteButton(pos)
//                        }
//                    )
//                )
//            }
//        }
    }

    private fun deleteButton(
        listPosition: Int
    ): SwipeHelper2.UnderlayButton {
        return SwipeHelper2.UnderlayButton(
            controller.requireContext(),
            "Delete",
            14.0f,
            android.R.color.holo_red_light,
            object : SwipeHelper2.UnderlayButtonClickListener {
                @SuppressLint("NotifyDataSetChanged")
                override fun onClick() {
                    scheduleList.removeAt(listPosition)
                    mainActivityContext.removeSharedPreferences("scheduleList")
                    val json = Gson().toJson(scheduleList)
                    mainActivityContext.setSharedPreferences()?.putString("scheduleList", json)?.apply()

                    initAdapterSchedule()
                }
            })
    }
}