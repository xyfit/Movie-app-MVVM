package com.example.recycler

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    @SuppressLint("Telegraph", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recac)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        val list = listOf<usermadel>(
            usermadel(R.drawable.ic_baseline_23mp_24,"DELL"),
            usermadel(R.drawable.ic_baseline_23mp_24,"DELL"),
            usermadel(R.drawable.ic_baseline_23mp_24,"DELL"),
            usermadel(R.drawable.ic_baseline_23mp_24,"DELL"),
            usermadel(R.drawable.ic_baseline_23mp_24,"DELL"),
            usermadel(R.drawable.ic_baseline_23mp_24,"DELL"),
            usermadel(R.drawable.ic_baseline_23mp_24,"DELL"),
            usermadel(R.drawable.ic_baseline_23mp_24,"DELL"),
            usermadel(R.drawable.ic_baseline_23mp_24,"DELL"),
            usermadel(R.drawable.ic_baseline_23mp_24,"DELL"),
            usermadel(R.drawable.ic_baseline_23mp_24,"DELL"),
            usermadel(R.drawable.ic_baseline_23mp_24,"DELL"),
            usermadel(R.drawable.ic_baseline_23mp_24,"DELL"),
            usermadel(R.drawable.ic_baseline_23mp_24,"DELL"),
        )

        recyclerView.adapter=UserAdapter(list)
    }
}