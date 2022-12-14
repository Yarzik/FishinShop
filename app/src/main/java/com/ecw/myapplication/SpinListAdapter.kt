package com.bam.shopproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bam.shopproject.databinding.BootsListItemBinding
import com.bam.shopproject.room.BootsData
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

class SpinListAdapter : RecyclerView.Adapter<SpinListAdapter.ViewHolder>() {

    var items: List<BootsData> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    private var itemClick: (BootsData) -> Unit = {}
    fun itemClick(listener: (BootsData) -> Unit) {
        itemClick = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.boots_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.boots = items[position]
        holder.itemView.setOnClickListener {
            itemClick(items[position])
        }
        val url = items[position].img
        Picasso.get()
            .load(url)
            .error(R.drawable.ic_baseline_hide_image_24)
            .fit()
            .into(holder.binding.image, object : Callback{
                override fun onSuccess() {

                }

                override fun onError(e: Exception?) {

                }

            })
    }

    override fun getItemCount(): Int {
        return items.size
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var binding = BootsListItemBinding.bind(view)

    }
}