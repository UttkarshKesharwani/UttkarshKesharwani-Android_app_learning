package com.example.shoppingapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.shoppingapp.databinding.RvItemBinding

class ProductAdapter (var context : Context, var productList : ArrayList<ProductModel>):RecyclerView.Adapter<ProductAdapter.viewHolder>()  {
    inner class viewHolder (var binding : RvItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        var binding = RvItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return viewHolder(binding)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
       holder.binding.productImage.load(productList.get(position).imageUrl){
           placeholder(R.drawable.girl_image)
       }

        holder.binding.productName.text=productList.get(position).name
        holder.binding.productCode.text=productList.get(position).productCode
        holder.binding.prodcutPrice.text=productList.get(position).price.toString()



        context.startActivity(Intent(context,DetailActivity::class.java).putExtra("PRODUCT_ID",productList.get(position).id) )


    }
}