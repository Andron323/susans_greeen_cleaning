package com.procreations.susansgreeencleaning

import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.app.NotificationCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.procreations.susansgreeencleaning.databinding.ActivityMainBinding
import com.procreations.susansgreeencleaning.ui.WelcomeFragment
import com.procreations.susansgreeencleaning.ui.home.HomeFragment


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTheme(R.style.Theme_SusansGreeenCleaning)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.activityNavHost) as NavHostFragment
        navController = navHostFragment.navController


    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    fun openUrl(url:String){
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(browserIntent)
    }
    fun startCall(url:String){
        val callIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$url"))
        startActivity(callIntent)
    }


    fun setSharedPreferences(): SharedPreferences.Editor? {
        return getSharedPreferences("LOCAL_DB", MODE_PRIVATE)?.edit()
    }//    local_db?.putInt("name_data", data)
    //    local_db?.apply()

    fun getSharedPreferences(): SharedPreferences? {
        return getSharedPreferences("LOCAL_DB", MODE_PRIVATE)
    }//    var samVar = local_db.getInt("name_data", defaultData)

    fun removeSharedPreferences (removeKey:String){
        val preferences: SharedPreferences = getSharedPreferences("LOCAL_DB", 0)
        preferences.edit().apply {
            remove(removeKey)
        }.apply()
    }

    override fun onBackPressed() {

        val navHostFragment: NavHostFragment? = supportFragmentManager.findFragmentById(R.id.activityNavHost) as NavHostFragment?
        val fragment = navHostFragment!!.childFragmentManager.fragments[0]
        println("FRAGMENT_NAW $fragment")

        if (fragment is WelcomeFragment){
            return
        }
        if (fragment is HomeFragment){
            return
        }
        super.onBackPressed()
    }

}