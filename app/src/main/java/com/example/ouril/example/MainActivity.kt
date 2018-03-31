package com.example.ouril.example



import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.ActionMode
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.AbsListView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.PopupMenu
import com.example.ouril.example.models.CityWhether
import com.example.ouril.example.models.Whether
import android.support.v7.widget.LinearLayoutManager


import android.support.v7.widget.RecyclerView
import java.util.ArrayList
import java.util.List


class MainActivity: AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.main_activity)

        val cites: ArrayList<CityWhether> = ArrayList()
        for (i: Int in 1..5) {
            val name: String = "City " + i.toString()
            cites.add(CityWhether(name, Whether.SUNNY))
        }

        val testData: ArrayList<String> = ArrayList()
        for (i: Int in 1..5) {
            val name: String = "City " + i.toString()
            testData.add(CityWhether(name, Whether.SUNNY).name)
        }

        viewManager = LinearLayoutManager(this)
        viewAdapter = WhetherAdapter(cites)

        recyclerView = findViewById<RecyclerView>(  R.id.fp_container_root).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter

        }

        recyclerView.adapter = viewAdapter


    }
}