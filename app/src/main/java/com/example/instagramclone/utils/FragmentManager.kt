package com.example.instagramclone.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView

object FragmentManager {

    private lateinit var currentActivity: AppCompatActivity
    private lateinit var currentHostFragmentView: FragmentContainerView

    fun openFragment(fragment: Fragment, addToBackStack: Boolean = false) {
        if (addToBackStack) {
            currentActivity.supportFragmentManager.beginTransaction().replace(currentHostFragmentView.id, fragment).addToBackStack(null).commit()
        } else {
            currentActivity.supportFragmentManager.beginTransaction().replace(currentHostFragmentView.id, fragment).commit()
        }


    }

    fun setCurrentActivity(pActivity: AppCompatActivity) {
        currentActivity = pActivity
    }
    fun setCurrentHostFragmentView(pFragmentView: FragmentContainerView) {
        currentHostFragmentView = pFragmentView
    }
}