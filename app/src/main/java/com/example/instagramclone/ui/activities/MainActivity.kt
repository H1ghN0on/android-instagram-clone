package com.example.instagramclone.ui.activities

import com.example.instagramclone.R
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.findFragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.instagramclone.databinding.ActivityMainBinding
import com.example.instagramclone.ui.fragments.HomeFragment
import com.example.instagramclone.ui.fragments.LikesFragment
import com.example.instagramclone.ui.fragments.ProfileFragment
import com.example.instagramclone.ui.fragments.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)


        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.hostFragment
        ) as NavHostFragment

        val navController = navHostFragment.navController

        binding.bottomNavigation.setOnItemSelectedListener {
            navController.navigate(it.itemId)
            true
        }

    }

}