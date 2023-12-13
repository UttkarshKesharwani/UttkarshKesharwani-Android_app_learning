package com.example.rv_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rv_view.databinding.RvBinding

class Adapter(var dataList: ArrayList<Model>):RecyclerView.Adapter<Adapter.ViewHolder>() {

    inner class ViewHolder(var binding: RvBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
         var binding = RvBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return  dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.imageView.setImageResource(dataList.get(position).mainImg)
        holder.binding.tvlarge.text=dataList.get(position).large
        holder.binding.tvsmall.text=dataList.get(position).small
    }
}