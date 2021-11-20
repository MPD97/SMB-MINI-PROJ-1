package com.example.smb_mini_proj_1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.smb_mini_proj_1.databinding.ActivityProductEditBinding

class ProductEditActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun productListClick(view: android.view.View) {
        startActivity(Intent(this, ProductListActivity::class.java))
    }
    fun settingsClick(view: android.view.View) {
        startActivity(Intent(this, OptionsActivity::class.java))
    }
}