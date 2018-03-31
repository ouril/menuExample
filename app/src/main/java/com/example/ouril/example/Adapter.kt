package com.example.ouril.example

import android.support.v7.widget.PopupMenu
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.ouril.example.models.CityWhether


interface WhetherAdapterClickListener {

    fun removeView(position:Int)

    fun editView(position: Int)
}


class WhetherAdapter(private val myDataset: ArrayList<CityWhether>) :
        RecyclerView.Adapter<WhetherAdapter.ViewHolder>() {

    class ViewHolder(val textView: View): RecyclerView.ViewHolder(textView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): WhetherAdapter.ViewHolder {

        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_city, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        //holder.textView.text = myDataset[position].toString()
    }
    
    override fun getItemCount() = myDataset.size
}


