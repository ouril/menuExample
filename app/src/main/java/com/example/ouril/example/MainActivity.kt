package com.example.ouril.example



import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager


import android.support.v7.widget.RecyclerView
import com.example.ouril.example.models.CityWhether
import com.example.ouril.example.models.Whether


class MainActivity: AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("hello")

        val cites: ArrayList<CityWhether> = ArrayList()
        for (i: Int in 1..5) {
            val name: String = "City " + i.toString()
            cites.add(CityWhether(name, Whether.SUNNY))
        }

        println("-------------------------------${cites}")

        viewManager = LinearLayoutManager(this)
        viewAdapter = WhetherAdapter(cites)

        recyclerView = findViewById<RecyclerView>(R.id.listView).apply {

            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter

        }

    }
}