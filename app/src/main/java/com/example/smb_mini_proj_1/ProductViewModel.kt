package com.example.smb_mini_proj_1

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class ProductViewModel (application: Application) : AndroidViewModel(application) {

    private val repository: ProductRepository
    val allProducts: LiveData<List<Product>>

    init{
        repository = ProductRepository(ProductDb.getDatabase(application.applicationContext).productDao())
        allProducts = repository.allProducts
    }

    fun insert(product: Product) = repository.insert(product)

    fun delete(product: Product) = repository.delete(product)

    fun update(product: Product) = repository.update(product)
}