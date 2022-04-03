package com.example.instagramclone.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.instagramclone.R
import com.example.instagramclone.databinding.FragmentAuthPasswordInputBinding
import com.example.instagramclone.utils.FragmentManager

class AuthPasswordInputFragment : Fragment() {

    class ValidationFields(pLength: Boolean, pLetterCase: Boolean, pSymbols: Boolean) {
        public val length = pLength
        public val letterCase = pLetterCase
        public val symbols = pSymbols
    }

    private val TAG = "AuthPasswordInputFragment"
    private lateinit var binding: FragmentAuthPasswordInputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAuthPasswordInputBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        binding.input.addTextChangedListener(object: TextWatcher {
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int) {

            }
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int,
                                           after:Int) {
            }
            override fun afterTextChanged(s: Editable) {
                binding.registerBtn.isEnabled = checkValidation()
            }
        })

        binding.registerBtn.setOnClickListener {
            FragmentManager.openFragment(AuthBirthdayInputFragment(), true)
        }


        return binding.root
    }

    private fun checkValidation(): Boolean {

        val text = binding.input.text
        val passwordSymbolsPattern = Regex("(?=.*[@_*!]).*\$")
        val passwordLetterCasePattern = Regex("(?=.*[a-z])(?=.*[A-Z]).*\$")
        val passwordPattern = Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@_*])(?=\\S+\$).{8,15}\$")

        toggleValidationView(binding.validationLength, binding.lengthIcon, text.length in 8..15)
        toggleValidationView(binding.validationLetterCase, binding.letterCaseIcon, passwordLetterCasePattern.matches(text))
        toggleValidationView(binding.validationSymbols, binding.symbolsIcon, passwordSymbolsPattern.matches(text))
        return passwordPattern.matches(text)
    }

    private fun toggleValidationView(textView: TextView, imageView: ImageView, activate: Boolean) {
        if (!activate) {
            textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.gray))
            imageView.setImageDrawable(resources.getDrawable(R.drawable.ic_abort, requireContext().theme))
            imageView.setColorFilter(ContextCompat.getColor(requireContext(), R.color.gray))
        } else {
            textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.blue))
            imageView.setImageDrawable(resources.getDrawable(R.drawable.ic_check, requireContext().theme))
            imageView.setColorFilter(ContextCompat.getColor(requireContext(), R.color.blue))
        }
    }

    companion object {

        fun newInstance(param1: String, param2: String) = AuthPasswordInputFragment()
    }
}