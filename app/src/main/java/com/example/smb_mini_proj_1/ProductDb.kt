package com.example.smb_mini_proj_1

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Product::class], version = 1)
abstract class ProductDb : RoomDatabase() {

    abstract fun productDao(): ProductDao

    companion object{

        private var instance: ProductDb? = null

        fun getDatabase(context: Context): ProductDb{
            if(instance != null)
                return instance!!
            instance = Room.databaseBuilder(
                context,
                ProductDb::class.java,
                "ProductDatabase"
            ).allowMainThreadQueries().build()
            return instance!!
        }
    }
}