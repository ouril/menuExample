package com.example.ouril.example

import android.support.v7.widget.CardView
import android.support.v7.widget.PopupMenu
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.ouril.example.models.CityWhether
import com.example.ouril.example.models.Whether
import kotlinx.android.synthetic.main.item_city.view.*
import javax.security.auth.callback.Callback


interface WhetherAdapterClickListener {

    fun removeView(position:Int)

    fun editView(position: Int)

    fun addView(text: String, whether: Whether)
}


class WhetherAdapter(private val myDataset: ArrayList<CityWhether>) :
        RecyclerView.Adapter<WhetherAdapter.ViewHolder>(), WhetherAdapterClickListener {

    override fun removeView(position: Int){
        myDataset.removeAt(position)
        notifyDataSetChanged()
    }

    override fun editView(position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addView(text: String, whether: Whether) {
        val cityWhether = CityWhether(text, whether)
        myDataset.add(cityWhether)
        notifyDataSetChanged()
    }

    inner class ViewHolder(val textView: View): RecyclerView.ViewHolder(textView),
            View.OnClickListener,
            PopupMenu.OnMenuItemClickListener{

        val mTextView = textView.findViewById(R.id.txtTitle) as TextView
        val mContextView = textView.findViewById(R.id.txtOptionDigit) as TextView

        init {
            mContextView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            when(v!!.id) {
                R.id.txtOptionDigit -> {
                    val popup = PopupMenu(v.context, v)
                    popup.inflate(R.menu.contex_menu)
                    popup.setOnMenuItemClickListener(this)
                    popup.show()
                }
            }
        }

        override fun onMenuItemClick(item: MenuItem?): Boolean {
            when(item!!.itemId) {
                R.id.menu_edit -> {
                    return true
                }
                R.id.menu_delete -> {
                    removeView(this.adapterPosition)
                    return true

                }
            }
            return false
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): WhetherAdapter.ViewHolder {

        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_city, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.textView.txtTitle.text = myDataset[position].name
        holder.textView.txtWhether.text = myDataset[position].whether.toString()
    }
    
    override fun getItemCount() = myDataset.size
}


