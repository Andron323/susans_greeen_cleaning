package com.procreations.susansgreeencleaning.ui.reminder

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ReminderPresenter(var controller: ReminderFragment) {

    var notification : ArrayList<ImageView> = ArrayList()

    lateinit var rvSchedule: RecyclerView
    lateinit var floatingAddBtn: FloatingActionButton

    init {
        initUI()
        setupNotification(1)
    }

    private fun initUI() {
        notification.add(controller.binding.notificationOn)
        notification.add(controller.binding.notificationOff)

        rvSchedule = controller.binding.rvSchedule
        floatingAddBtn = controller.binding.floatingAddBtn
    }

    fun setupNotification(state:Int) {
        for (i in notification){
            i.visibility = View.VISIBLE
        }
        notification[state].visibility = View.GONE
    }
}