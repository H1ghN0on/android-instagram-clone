package com.example.instagramclone.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.instagramclone.databinding.FragmentAuthConfirmationCodeBinding
import com.example.instagramclone.utils.FragmentManager


class AuthConfirmationCodeFragment : Fragment() {

    private val TAG = "AuthRegistrationProfileFragment"
    private lateinit var binding: FragmentAuthConfirmationCodeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAuthConfirmationCodeBinding.inflate(layoutInflater)
        binding.input.addTextChangedListener(object: TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

                binding.registerBtn.isEnabled = s.toString().trim { it <= ' ' }.isNotEmpty()
            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int, count: Int,
                after: Int
            ) {
            }

            override fun afterTextChanged(s: Editable) {
            }
        })

        binding.registerBtn.setOnClickListener {
            FragmentManager.openFragment(AuthBirthdayInputFragment(), true)
        }

        return binding.root
    }

    companion object {

        fun newInstance(param1: String, param2: String) = AuthConfirmationCodeFragment()
    }
}