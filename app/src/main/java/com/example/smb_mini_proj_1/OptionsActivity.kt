package com.example.smb_mini_proj_1

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.smb_mini_proj_1.databinding.ActivityOptionsBinding
import android.widget.RadioGroup
import android.widget.RadioButton
import android.R
import android.graphics.Color


class OptionsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOptionsBinding
    private lateinit var sp: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOptionsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sp = getPreferences(Context.MODE_PRIVATE)
        val editor = sp.edit()

        binding.checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
            editor.putBoolean("background-blue", isChecked)
            editor.apply()

            if(isChecked) {
                binding.textView3.setTextColor(Color.BLUE)
            }
            else {
                binding.textView3.setTextColor(Color.BLACK)
            }
        }
        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val rb = findViewById<View>(checkedId) as RadioButton
            editor.putString("font-size", rb.text.toString())
            editor.apply()
            when (rb.text.toString()) {
                "14dp" -> {
                    binding.textView3.textSize = 14.0F
                }
                "16dp" ->{
                    binding.textView3.textSize = 16.0F
                }
                "18dp" -> {
                    binding.textView3.textSize = 18.0F
                }
            }
        }

    }

    override fun onStart() {
        super.onStart()

        if(sp.getBoolean("background-blue", false)) {
            binding.checkBox.isChecked = true
            binding.textView3.setTextColor(Color.BLUE)
        }
        else {
            binding.checkBox.isChecked = false
            binding.textView3.setTextColor(Color.BLACK)
        }

        when (sp.getString("font-size", "14dp")) {
            "14dp" -> {
                binding.radioButton.isChecked = true
                binding.textView3.textSize = 14.0F
            }
            "16dp" ->{
                binding.radioButton2.isChecked = true
                binding.textView3.textSize = 16.0F
            }
            "18dp" -> {
                binding.radioButton3.isChecked = true
                binding.textView3.textSize = 18.0F
            }
        }
    }
}