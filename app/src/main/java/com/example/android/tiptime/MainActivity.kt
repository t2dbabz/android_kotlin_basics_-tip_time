package com.example.android.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener { calculateTip() }
    }

     fun calculateTip() {
        val stringInTextField = binding.costOfService.text.toString()
        val cost = stringInTextField.toDouble()
        val selectedId =binding.tipsOptions.checkedRadioButtonId
        val tipPercentage = when(selectedId){
             R.id.options_twenty_percent -> 0.20
             R.id.options_eighteen_percent -> 0.18
             else -> 0.15
        }

         var tip = cost * tipPercentage
         val roundUp = binding.roundUpSwitch.isChecked
         if(roundUp){
             tip = kotlin.math.ceil(tip)
         }

         val tipFormatted = NumberFormat.getCurrencyInstance().format(tip)
         binding.tipResult.text = getString(R.string.tip_amount, tipFormatted)

     }
}