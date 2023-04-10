package com.procreations.susansgreeencleaning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.procreations.susansgreeencleaning.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setTheme(R.style.Theme_SusansGreeenCleaning)

//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)

//        val navHostFragment = activityNavHost as NavHostFragment
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.activityNavHost) as NavHostFragment
        navController = navHostFragment.navController
    }
}