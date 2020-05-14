package com.asysyifazahrasalsabila.pat_emergencycall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rv: RecyclerView
    private var list: ArrayList<Model> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv = findViewById(R.id.rv)

        list.addAll(Data.listData)
        rv.layoutManager = LinearLayoutManager(this)

        val listAdapter = AdapterRV(list)
        rv.adapter = listAdapter

    }
}
