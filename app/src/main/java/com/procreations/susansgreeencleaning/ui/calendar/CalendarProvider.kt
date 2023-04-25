package com.procreations.susansgreeencleaning.ui.calendar

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Build
import android.view.View
import android.view.Window
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.procreations.susansgreeencleaning.MainActivity
import com.procreations.susansgreeencleaning.R
import com.procreations.susansgreeencleaning.model.Schedule
import java.lang.reflect.Type
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
class CalendarProvider(var controller: CalendarFragment) {

    private var presenter: CalendarPresenter? = null
    private var scheduleList: ArrayList<Schedule> = ArrayList()
    private var mainActivityContext = (controller.activity as MainActivity)
    private var fabType = ""

    private var userDate = ""
    private var userTime = ""
    private var userDateRepeat = ""




    init {
        presenter = CalendarPresenter(controller)
        getData()
        initTargets()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun getData() {

        setNawData()

        fabType = controller.arguments?.getString("fabType").toString()

        val reminder = mainActivityContext.getSharedPreferences()?.getString("scheduleList",null)
        val gson = Gson()
        val type: Type = object : TypeToken<ArrayList<Schedule>>() {}.type

        if (reminder != null) {
            scheduleList = gson.fromJson<Any>(reminder, type) as ArrayList<Schedule>
        }
    }

    private fun setNawData() {
        val selectedDate = presenter?.calendarView!!.date
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = selectedDate
        val dateFormatter = DateFormat.getDateInstance(DateFormat.SHORT)
        val date =dateFormatter.format(calendar.time)
        println("NAW_DATE $date")
        presenter?.setDate?.text = date
    }

    private fun initTargets() {
        presenter?.apply {

            saveTxt.setOnClickListener {
                setData()
            }
            cancelTxt.setOnClickListener {
                mainActivityContext.onBackPressed()
            }

            calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
                val date = "$dayOfMonth.${month + 1}.$year"
                println("SELECT_DATE $date")
                setDate.text = date
            }
            setTime.setOnClickListener {
                getTime(setTime, context = controller.requireContext())
            }
            repeat.setOnClickListener {
                getDate(repeat, context = controller.requireContext())
            }
            newReminder.imeOptions = EditorInfo.IME_ACTION_DONE;
        }
    }

    private fun setData() {
        val time = presenter?.setTime?.text.toString()

        if (!time.isNullOrEmpty()){
            userTime = convertTimeFormat(time)

//            val repeat = presenter?.repeat?.text.toString()
//            if (!repeat.contains(""))userDateRepeat = repeat

            scheduleList.add(
                Schedule(
                    null,
                    if (fabType.contains("General"))R.drawable.bucket else R.drawable.sponge,
                    if (fabType.contains("General"))"General cleanig" else "Standart cleanig",
                    if (fabType.contains("General"))"Cleaning and organizing is a practice not a project" else "Cleanliness makes it easier to see the details",
                    time = userTime,
                    date = presenter?.setDate?.text.toString(),
                    repeat = presenter?.repeat?.text.toString(),
                    presenter?.newReminder?.text.toString()
                ))
            val json = Gson().toJson(scheduleList)
            mainActivityContext.setSharedPreferences()?.putString("scheduleList", json)?.apply()

            mainActivityContext.onBackPressed()
        }
        else{
            showDialog("Enter time, Please")
        }
    }

    private fun convertTimeFormat(time: String): String {
        return try {
            val sdf = SimpleDateFormat("H:mm")
            val dateObj = sdf.parse(time)
            System.out.println(dateObj)
            SimpleDateFormat("K:mm a").format(dateObj)
        } catch (e: ParseException) {
            e.printStackTrace()
            time
        }
    }

    fun getTime(textView: TextView, context: Context){

        val cal = Calendar.getInstance()

        val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
            cal.set(Calendar.HOUR_OF_DAY, hour)
            cal.set(Calendar.MINUTE, minute)

            textView.text = SimpleDateFormat("HH:mm").format(cal.time)
        }

//        textView.setOnClickListener {
            TimePickerDialog(context, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()
//        }
    }

    fun getDate(textView: TextView,context: Context){

//        textView.text = SimpleDateFormat("dd.MM.yyyy").format(System.currentTimeMillis())

        val cal = Calendar.getInstance()

        val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val myFormat = "dd.MM.yyyy" // mention the format you need
            val sdf = SimpleDateFormat(myFormat, Locale.US)
            textView.text = sdf.format(cal.time)

        }

//        textView.setOnClickListener {
            DatePickerDialog(context, dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)).show()
//        }
    }

    private fun showDialog(title: String) {
        val dialog = Dialog(controller.requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.custom_dialog_layout)
        val body = dialog.findViewById(R.id.body) as TextView
        body.text = title
        val yesBtn = dialog.findViewById(R.id.yesBtn) as Button
        val noBtn = dialog.findViewById(R.id.noBtn) as Button
        noBtn.visibility = View.GONE
        yesBtn.setOnClickListener {
            dialog.dismiss()
        }
        noBtn.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()

    }

}