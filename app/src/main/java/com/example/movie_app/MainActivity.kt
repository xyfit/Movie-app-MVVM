package com.example.recycler

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler.databinding.ActivityMainBinding
import com.example.recycler.models.MovieModel
import com.example.recycler.nerwork.NetManager
import com.example.recycler.viewmodel.MyViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MyViewModel

    @SuppressLint("Telegraph", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        viewModel = ViewModelProvider(this)[MyViewModel::class.java]


        setContentView(view)
        loadApi()
        initRec()
        initLiveData()

        viewModel.movieLoadApi()

        binding.swipeRefresh.setOnRefreshListener {
            viewModel.movieLoadApi()
        }

    }

    private fun initLiveData() {
        viewModel.dataList.observe(this, Observer {
            binding.recyclerMain.adapter = UserAdapter(it, object : OnItemCallback { override fun subMemberItemClick(s: MovieModel) {} }) })

        viewModel.error.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })

        viewModel.progress.observe(this, Observer {
            binding.swipeRefresh.isRefreshing = it
        })
    }

    private fun initRec() {
        binding.recyclerMain.layoutManager = LinearLayoutManager(this)
    }

    private fun loadApi() {

    }
}


/*       recyclerView = findViewById(R.id.recac)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
       recyclerView.layoutManager = GridLayoutManager(this, 2)

       val list = arrayListOf<usermadel>()
       for (i in 0..30){
           list.add(usermadel(R.drawable.ic_baseline_23mp_24,"DELL $i"))
       }

       recyclerView.adapter=UserAdapter(list,object:OnItemCallback{
           override fun subMemberItemClick(s: usermadel) {
               Toast.makeText(this@MainActivity, "$s", Toast.LENGTH_LONG).show()
   }
})
   }
}*/