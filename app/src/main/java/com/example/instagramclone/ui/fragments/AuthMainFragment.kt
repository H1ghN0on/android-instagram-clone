package com.example.instagramclone.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.instagramclone.R
import com.example.instagramclone.databinding.FragmentAuthMainBinding
import com.example.instagramclone.utils.FragmentManager


class AuthMainFragment : Fragment() {

    private val TAG = "AuthMainFragment"
    private lateinit var binding: FragmentAuthMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAuthMainBinding.inflate(layoutInflater)

        binding.loginBtn.setOnClickListener {
        }

        binding.registerBtn.setOnClickListener {
            FragmentManager.openFragment(AuthEmailFragment(), true)
        }
        return binding.root
    }

    companion object {

        fun newInstance(param1: String, param2: String) = AuthMainFragment
    }
}