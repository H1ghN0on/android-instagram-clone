package com.example.instagramclone.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.instagramclone.R
import com.example.instagramclone.databinding.ActivityAuthenticationBinding
import com.example.instagramclone.ui.fragments.AuthMainFragment

class AuthenticationActivity : AppCompatActivity() {

    private val TAG = "AuthenticationActivity"
    private lateinit var binding: ActivityAuthenticationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthenticationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().replace(binding.hostFragment.id, AuthMainFragment()).commit()


    }
}