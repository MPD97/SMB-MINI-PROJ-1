package com.example.smb_mini_proj_1

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.smb_mini_proj_1.databinding.ElementBinding

class ProductAdapter(private val productViewModel: ProductViewModel
) : RecyclerView.Adapter<ProductAdapter.CustomViewHolder>() {

    var products = emptyList<Product>()

    class CustomViewHolder(val binding: ElementBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductAdapter.CustomViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ElementBinding.inflate(inflater)
        return CustomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductAdapter.CustomViewHolder, position: Int) {
        val currentProduct = products[position]
        holder.binding.tvName.setText(currentProduct.name)
        holder.binding.tvAmount.setText(currentProduct.amount.toString())
        holder.binding.tvPrice.setText(currentProduct.price.toString())
        holder.binding.tvBought.isChecked = currentProduct.isBought

        holder.binding.tvBought.setOnCheckedChangeListener { _ , isChecked ->
            currentProduct.isBought = isChecked
            productViewModel.update(currentProduct)
        }
        holder.binding.tvDelete.setOnClickListener{ _ ->
            productViewModel.delete(currentProduct)
        }
        holder.binding.tvEdit.setOnClickListener{ _ ->
            currentProduct.name = holder.binding.tvName.text.toString()
            currentProduct.amount = holder.binding.tvAmount.text.toString().toInt()
            currentProduct.price = holder.binding.tvPrice.text.toString().toDouble()

            productViewModel.update(currentProduct)
        }
    }

    override fun getItemCount(): Int = products.size

    fun setProductList(products: List<Product>){
        this.products = products
        notifyDataSetChanged()
    }
}