package com.example.summerpractice22

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.summerpractice22.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        nameFocusListener()
        weightFocusListener()
        heightFocusListener()
        ageFocusListener()

        _binding.submitButton.setOnClickListener { submitForm() }

    }



    @SuppressLint("SetTextI18n")
    private fun submitForm() {
        _binding.nameContainer.helperText = validateName()
        _binding.heightContainer.helperText = validateHeight()
        _binding.weightContainer.helperText = validateWeight()
        _binding.ageContainer.helperText = validateAge()

        val validName = validateName() == null
        val validHeight = validateHeight() == null
        val validWeight = validateWeight() == null
        val validAge = validateAge() == null


        if (validName && validHeight && validWeight && validAge){
            calculateDCI()
        } else
            _binding.textView.text =  "Data entered incorrectly"
    }


    @SuppressLint("SetTextI18n")
    private fun calculateDCI() {
        val value = (_binding.weightEditText.text.toString().toDouble() * 10 + _binding.heightEditText.text.toString().toDouble() * 6.25 - _binding.ageEditText.text.toString().toDouble() * 5 - 5) * 1.38
        _binding.textView.text = "Name: ${_binding.nameEditText.text.toString()}\nОтвет: $value"
    }
    private fun nameFocusListener()
    {
        _binding.nameEditText.setOnFocusChangeListener { _, focused ->
            if(!focused)
            {
                _binding.nameContainer.helperText = null
            }
        }
    }
    private fun validateName(): String? {
        val nameText = _binding.nameEditText.text.toString()
        return if(nameText.length < 0 ){
            "Data entered incorrectly"
        } else
            return null
    }

    private fun heightFocusListener()
    {
        _binding.heightEditText.setOnFocusChangeListener { _, focused ->
            if(!focused)
            {
                _binding.heightContainer.helperText = validateHeight()
            }
        }
    }
    private fun validateHeight(): String? {
        val heightText = _binding.heightEditText.text.toString().toDouble()
        if(heightText < 0 || heightText > 250){
            return "Data entered incorrectly"
        }
        return null
    }

    private fun weightFocusListener()
    {
        _binding.weightEditText.setOnFocusChangeListener { _, focused ->
            if(!focused)
            {
                _binding.weightContainer.helperText = validateWeight()
            }
        }
    }
    private fun validateWeight(): String?{
        val weightText = _binding.weightEditText.text.toString().toDouble()
        if(weightText < 0 || weightText > 250){
            return "Data entered incorrectly"
        }
        return null
    }

    private fun ageFocusListener()
    {
        _binding.ageEditText.setOnFocusChangeListener { _, focused ->
            if(!focused)
            {
                _binding.ageContainer.helperText = validateAge()
            }
        }
    }
    private fun validateAge(): String?{
        val ageText = _binding.ageEditText.text.toString().toDouble()
        if(ageText < 0 || ageText > 150){
            return "Data entered incorrectly"
        }
        return null
    }
}