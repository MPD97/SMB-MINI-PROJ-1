package com.example.smb_mini_proj_1

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ProductDao {

    @Query("SELECT * FROM product")
    fun getProducts(): LiveData<List<Product>>

    @Update
    fun update(product: Product)

    @Insert
    fun insert(product: Product)

    @Delete
    fun delete(product: Product)

}