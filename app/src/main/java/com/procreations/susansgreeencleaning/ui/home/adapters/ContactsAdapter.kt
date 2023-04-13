package com.procreations.susansgreeencleaning.ui.home.adapters

import android.annotation.SuppressLint
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.procreations.susansgreeencleaning.R
import com.procreations.susansgreeencleaning.model.Contact
import com.procreations.susansgreeencleaning.ui.home.HomeFragment


class ContactsAdapter(
    private var itemList: ArrayList<Contact>? = ArrayList(),
    private var controller: HomeFragment

    ) : RecyclerView.Adapter<ContactsAdapter.ViewHolderPost>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPost {

        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_contact_list, parent, false)
        return ViewHolderPost(view)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolderPost, position: Int) {
        holder.bind(itemList!![position])
    }

    override fun getItemCount(): Int {

        return itemList!!.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    inner class ViewHolderPost(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val itemContact: LinearLayout = itemView.findViewById(R.id.item_contact)
        private val iconImg: ImageView = itemView.findViewById(R.id.icon_img)
        private val titleName: TextView = itemView.findViewById(R.id.title_name)

        @RequiresApi(Build.VERSION_CODES.O)
        @SuppressLint("SimpleDateFormat", "SetTextI18n", "UseCompatLoadingForDrawables")
        fun bind(itemList: Contact?) {

            if (itemList?.imageURL!=null){
                Glide.with(controller)
                    .load(itemList.imageURL)
                    .centerInside()
                    .into(iconImg)
            }else if (itemList?.imageRes!=null){
                iconImg.setImageDrawable(controller.context?.resources?.getDrawable(itemList.imageRes!!))
            }

            titleName.text = itemList?.title

            itemContact.setOnClickListener {
                Toast.makeText(controller.context, "Will be action to ${itemList?.title}", Toast.LENGTH_SHORT).show()
            }
        }
    }

}








