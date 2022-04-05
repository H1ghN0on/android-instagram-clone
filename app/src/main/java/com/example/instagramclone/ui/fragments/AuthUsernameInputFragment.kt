package com.example.instagramclone.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.text.SpannableString
import android.text.TextWatcher
import android.text.style.UnderlineSpan
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.instagramclone.R
import com.example.instagramclone.databinding.FragmentAuthUsernameInputBinding
import com.google.android.material.textfield.TextInputLayout.*


class AuthUsernameInputFragment : Fragment() {

    private val TAG = "AuthUsernameIpFragment"
    private lateinit var binding: FragmentAuthUsernameInputBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAuthUsernameInputBinding.inflate(layoutInflater)
        binding.input.addTextChangedListener(object: TextWatcher {
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int) {
                binding.registerBtn.isEnabled = s.toString().trim{ it <= ' ' }.isNotEmpty()
                binding.inputBox.endIconMode = END_ICON_NONE;
            }
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int,
                                           after:Int) {
            }
            override fun afterTextChanged(s: Editable) {

            }
        })

        binding.registerBtn.setOnClickListener {
            val inputValue = binding.input.text.toString()
            //plug
            if (!checkNameExistence(binding.input.text.toString())) {
                setInputErrorIcon()
                val names = generateNames(inputValue)
                binding.nameOffers.removeAllViews()
                names.forEach { name ->
                    binding.nameOffers.addView(createNameTextView(name))
                }
                binding.nameOffers.visibility = VISIBLE
                binding.nameOffersTitle.visibility = VISIBLE
            }
        }

        return binding.root
    }

    private fun generateNames(value: String): MutableList<String> {
        var names = mutableListOf<String>()
        var newName = value
        var i = 0
        while (names.count() != 3) {
            newName += ++i
            if (checkNameExistence(newName)) {
                names.add(newName)
            }
        }
        return names
    }

    //firebase request
    private fun checkNameExistence(value: String): Boolean {
        return value != "nickname.another";
    }

    private fun setInputErrorIcon() {
        binding.inputBox.endIconMode = END_ICON_CUSTOM;
        binding.inputBox.setEndIconDrawable(R.drawable.red_close)
    }

    private fun createNameTextView(value: String): TextView {
        val nameView = TextView(context)
        val spannableContent = SpannableString(value)
        spannableContent.setSpan(UnderlineSpan(),0,value.length,0)
        nameView.text = spannableContent
        nameView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f)
        val params: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        nameView.setOnClickListener {
            binding.input.setText(value)
            binding.input.setSelection(value.length)
        }
        params.setMargins(0, 0, 15, 0)
        nameView.setLayoutParams(params)
        return nameView
    }


    companion object {
        fun newInstance(param1: String, param2: String) = AuthUsernameInputFragment()
    }
}