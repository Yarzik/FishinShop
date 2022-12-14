package com.bam.shopproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bam.shopproject.databinding.SizeListItemBinding

class SpinSizeListAdapter : RecyclerView.Adapter<SpinSizeListAdapter.ViewHolder>() {

    private var items = mutableListOf<Double>()
    init {
        var size = 0.0
        while (size <=15 ){
            size +=0.5
            items.add(size)
        }
    }


    private var itemClick: (Double) -> Unit = {}
    fun itemClick(listener: (Double) -> Unit) {
        itemClick = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.size_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.sizeItemText.text = items[position].toString()
        holder.itemView.setOnClickListener {
            itemClick(items[position])
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var binding = SizeListItemBinding.bind(view)

    }
}