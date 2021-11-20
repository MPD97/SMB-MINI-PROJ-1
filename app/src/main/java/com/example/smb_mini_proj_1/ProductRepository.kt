package com.example.smb_mini_proj_1

import androidx.room.Update

class ProductRepository(private val productDao: ProductDao) {

    val allProducts = productDao.getProducts()

    fun update(product: Product) = productDao.update(product)

    fun insert(product: Product) = productDao.insert(product)

    fun delete(product: Product) = productDao.delete(product)

}