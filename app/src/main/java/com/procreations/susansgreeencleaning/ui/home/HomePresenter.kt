package com.procreations.susansgreeencleaning.ui.home

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

class HomePresenter(var controller: HomeFragment) {

    var notification : ArrayList<ImageView> = ArrayList()
    lateinit var giftCard: ImageView

    lateinit var rvContacts: RecyclerView
    lateinit var rvAboutUs: RecyclerView

    lateinit var bookBtn: MaterialButton
    lateinit var callBtn: MaterialButton



    init {
        initUI()
        setupNotification(0)
    }

    private fun initUI() {
        notification.add(controller.binding.notificationOn)
        notification.add(controller.binding.notificationOff)

        giftCard = controller.binding.giftCard
        rvContacts = controller.binding.rvContacts
        rvAboutUs = controller.binding.rvAboutUs
        bookBtn = controller.binding.bookBtn
        callBtn = controller.binding.callBtn
    }

    fun setupNotification(state:Int) {
        for (i in notification){
            i.visibility = View.VISIBLE
        }
        notification[state].visibility = View.GONE
    }
}