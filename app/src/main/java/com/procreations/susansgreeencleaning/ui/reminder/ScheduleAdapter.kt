package com.procreations.susansgreeencleaning.ui.reminder

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
import com.procreations.susansgreeencleaning.model.AboutUs
import com.procreations.susansgreeencleaning.model.Schedule
import com.procreations.susansgreeencleaning.ui.home.HomeFragment


class ScheduleAdapter(
    private var itemList: ArrayList<Schedule>? = ArrayList(),
    private var controller: ReminderFragment

    ) : RecyclerView.Adapter<ScheduleAdapter.ViewHolderPost>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPost {

        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_schedule_list, parent, false)
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
        private val title: TextView = itemView.findViewById(R.id.title)
        private val subTitle: TextView = itemView.findViewById(R.id.sub_title)
        private val time: TextView = itemView.findViewById(R.id.time)

        @RequiresApi(Build.VERSION_CODES.O)
        @SuppressLint("SimpleDateFormat", "SetTextI18n", "UseCompatLoadingForDrawables")
        fun bind(itemList: Schedule?) {

            if (itemList?.imageURL!=null){
                Glide.with(controller)
                    .load(itemList.imageURL)
                    .centerInside()
                    .into(iconImg)
            }else if (itemList?.imageRes!=null){
                iconImg.setImageDrawable(controller.context?.resources?.getDrawable(itemList.imageRes!!))
            }

            title.text = itemList?.title
            subTitle.text = itemList?.subTitle
            time.text = itemList?.time

            itemContact.setOnClickListener {
                Toast.makeText(controller.context, "Will be action to ${itemList?.title}", Toast.LENGTH_SHORT).show()
            }
        }
    }

}








