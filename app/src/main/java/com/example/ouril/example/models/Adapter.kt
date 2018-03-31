package com.example.ouril.example.models

import android.support.v7.widget.PopupMenu
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView



interface WhetherAdapterClickListener {

    fun removeView(position:Int)

    fun editView(position: Int)
}



// class WhetherAdapter: RecyclerView.Adapter<