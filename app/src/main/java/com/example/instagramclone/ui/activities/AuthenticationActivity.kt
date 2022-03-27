package com.example.instagramclone.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.instagramclone.R
import com.example.instagramclone.databinding.ActivityAuthenticationBinding
import com.example.instagramclone.ui.fragments.AuthEmailFragment
import com.example.instagramclone.ui.fragments.AuthMainFragment
import com.example.instagramclone.utils.FragmentManager

class AuthenticationActivity : AppCompatActivity() {

    private val TAG = "AuthenticationActivity"
    private lateinit var binding: ActivityAuthenticationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthenticationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initFragmentManager();
        FragmentManager.openFragment(AuthMainFragment())
    }

    private fun initFragmentManager() {
        FragmentManager.setCurrentActivity(this)
        FragmentManager.setCurrentHostFragmentView(binding.hostFragment)
    }


}

