package com.example.recycler

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var binding: ActivityMainBinding

    @SuppressLint("Telegraph", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initApi()
        initRec()
    }

    private fun initRec() {
        binding.recyclerMain.layoutManager = LinearLayoutManager(this)
    }

    private fun initApi() {
        NetManager.apiClient().getCourse().enqueue(object : Callback<List<MovieModel>> {
            override fun onResponse(
                call: Call<List<MovieModel>>,
                response: Response<List<MovieModel>>
            ) {
                if (response.isSuccessful) {
                    val getData = response.body()
                    getData?.let {
                    binding.recyclerMain.adapter = UserAdapter(getData, object : OnItemCallback{
                        override fun subMemberItemClick(s: MovieModel) {

                        }
                    })

                    }
                    val fffff = getData?.map { it.name }?.joinToString("\n")
                    Log.d("sssssssddfgfg", "$fffff")
                }
            }

            override fun onFailure(call: Call<List<MovieModel>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.localizedMessage}", Toast.LENGTH_LONG).show()
            }
        })
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