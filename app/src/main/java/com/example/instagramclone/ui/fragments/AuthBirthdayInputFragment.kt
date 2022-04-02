package com.example.instagramclone.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import com.example.instagramclone.R
import com.example.instagramclone.databinding.FragmentAuthBirthdayInputBinding
import com.example.instagramclone.utils.FragmentManager
import java.sql.Date
import java.util.*


class AuthBirthdayInputFragment : Fragment() {

    private val TAG = "AuthBirthInputFragment"
    private lateinit var binding: FragmentAuthBirthdayInputBinding
    private val calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAuthBirthdayInputBinding.inflate(layoutInflater)

        binding.registerBtn.setOnClickListener {
            FragmentManager.openFragment(AuthUsernameInputFragment(), true)
        }

        binding.datePicker.init(
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH))
        { view, year, monthOfYear, dayOfMonth ->

            val years  = countUserYears(dayOfMonth, monthOfYear, year)

            binding.input.setText("${dayOfMonth} ${Months.values()[monthOfYear]} ${year}")
            binding.userYears.text = ("${years} years")

            binding.registerBtn.isEnabled = years >= 13
        }
        binding.datePicker.maxDate = Calendar.getInstance().timeInMillis


        return binding.root
    }

    companion object {

        fun newInstance(param1: String, param2: String) = AuthBirthdayInputFragment()
    }

    enum class Months {
        January, February, March, April, May, June, July, August, September, October, November, December
    }

    private fun countUserYears(uDays: Int, uMonths: Int, uYears: Int): Int {
        var value = calendar.get(Calendar.YEAR) - uYears
        if (uMonths > calendar.get(Calendar.MONTH)) {
            value--
        } else if (uMonths == calendar.get(Calendar.MONTH)
            && uDays > calendar.get(Calendar.DAY_OF_MONTH)) {
            value--
        }
        return value
    }

}