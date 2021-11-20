package com.example.smb_mini_proj_1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatDelegate
import com.example.smb_mini_proj_1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sp: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        sp = getPreferences(Context.MODE_PRIVATE)
        if(sp.getBoolean("dark-mode", false)){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
        else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

    fun productListClick(view: android.view.View) {
        startActivity(Intent(this, ProductListActivity::class.java))
    }
    fun settingsClick(view: android.view.View) {
        startActivity(Intent(this, OptionsActivity::class.java))
    }
}