package com.procreations.susansgreeencleaning.ui.home

import androidx.recyclerview.widget.LinearLayoutManager
import com.procreations.susansgreeencleaning.R
import com.procreations.susansgreeencleaning.model.AboutUs
import com.procreations.susansgreeencleaning.model.Contact
import com.procreations.susansgreeencleaning.ui.home.adapters.AboutUsAdapter
import com.procreations.susansgreeencleaning.ui.home.adapters.ContactsAdapter

class HomeProvider(var controller: HomeFragment) {
    private var presenter: HomePresenter? = null
    private var contactsList: ArrayList<Contact> = ArrayList()
    private var aboutUsList: ArrayList<AboutUs> = ArrayList()

    init {
        presenter = HomePresenter(controller)
        setData()
        initTargets()
        initAdapterContact()
        initAdapterAboutUs()
    }

    private fun setData() {
        contactsList.apply {
            add(
                Contact(
                    null,
                    R.drawable.google,
                    "Google",
                    ""
                )
            )
            add(
                Contact(
                    null,
                    R.drawable.yelp,
                    "Yelp",
                    ""
                )
            )
            add(
                Contact(
                    null,
                    R.drawable.angles,
                    "Angies List",
                    ""
                )
            )
        }

        aboutUsList.apply {
            add(
                AboutUs(
                    null,
                    R.drawable.about_phylosophy,
                    "Phylosophy",
                    "Do you know who’s cleaning your home? We do!",
                    ""
                )
            )
            add(
                AboutUs(
                    null,
                    R.drawable.about_pure_ingredients,
                    "Pure Ingredients",
                    "We use all natural, non-toxic, effective ingredients.",
                    ""
                )
            )
            add(
                AboutUs(
                    null,
                    R.drawable.about_vapor_cleaning,
                    "Vapor Cleaning",
                    "We use all natural, non-toxic, effective ingredients.",
                    ""
                )
            )
            add(
                AboutUs(
                    null,
                    R.drawable.about_desinfection,
                    "Desinfection",
                    "Harmful pathogens can live on surfaces for days, and will potentially",
                    ""
                )
            )
        }
    }

    private fun initAdapterContact() {
        presenter?.apply {
            rvContacts.apply {
                layoutManager =
                    LinearLayoutManager(controller.context, LinearLayoutManager.HORIZONTAL, false)
                adapter = ContactsAdapter(contactsList, controller)
            }
        }
    }

    private fun initAdapterAboutUs() {
        presenter?.apply {
            rvAboutUs.apply {
                layoutManager =
                    LinearLayoutManager(controller.context)
                adapter = AboutUsAdapter(aboutUsList, controller)
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
            bookBtn.setOnClickListener {

            }
            callBtn.setOnClickListener {

            }
        }
    }

}