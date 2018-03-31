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

import java.util.ArrayList
import java.util.List


class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.main_activity)

        val cites: ArrayList<CityWhether> = ArrayList()
        for (i:Int in 1..5) {
            val name: String = "City " + i.toString()
            cites.add(CityWhether(name, Whether.SUNNY))
        }
    }
}