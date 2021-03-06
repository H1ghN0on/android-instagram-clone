package com.example.instagramclone.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.instagramclone.R
import com.example.instagramclone.databinding.FragmentAuthNameInputBinding
import com.example.instagramclone.utils.FragmentManager


class AuthNameInputFragment : Fragment() {

    private val TAG = "AuthNameInputFragment"
    private lateinit var binding: FragmentAuthNameInputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAuthNameInputBinding.inflate(layoutInflater)

        binding.registerBtn.setOnClickListener {
            FragmentManager.openFragment(AuthPasswordInputFragment(), true)
        }

        binding.input.addTextChangedListener(object: TextWatcher {
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int) {

                binding.registerBtn.isEnabled = s.toString().trim{ it <= ' ' }.isNotEmpty()
            }
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int,
                                           after:Int) {
            }
            override fun afterTextChanged(s: Editable) {
            }
        })

        return binding.root
    }

    companion object {
        fun newInstance(param1: String, param2: String) = AuthNameInputFragment()
    }
}