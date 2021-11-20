package com.example.smb_mini_proj_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.smb_mini_proj_1.databinding.ActivityProductListBinding


class ProductListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rv1.layoutManager = LinearLayoutManager(this)
        binding.rv1.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )

        val productViewModel = ProductViewModel(application)
        val adapter = ProductAdapter(productViewModel)

        binding.rv1.adapter = adapter
        productViewModel.allProducts.observe(this, Observer{
            it.let{
                adapter.setProductList(it)
            }
        })

        binding.btAdd.setOnClickListener {
            val product = Product(
                name = binding.etName.text.toString(),
                amount = binding.etAmount.text.toString().toInt(),
                price = binding.etPrice.text.toString().toDouble(),
                isBought = false
            )
            productViewModel.insert(product)
        }
    }
}