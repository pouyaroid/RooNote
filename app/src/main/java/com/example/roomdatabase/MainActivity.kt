 package com.example.roomdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdatabase.databinding.ActivityMainBinding
import com.example.roomdatabase.room.AppDatabase
import kotlinx.coroutines.launch

 class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnAdd.setOnClickListener {
            val intent=Intent(this,AddActivity::class.java)
            startActivity(intent)

        }

    }

     override fun onResume() {
         super.onResume()
         lifecycleScope.launch {
           val userList=  AppDatabase(this@MainActivity).getUserDao().getAllUser()
            binding.recyclerview.apply {
                layoutManager=LinearLayoutManager(this@MainActivity)
                adapter=UserAdapetr().apply {
                    setData(userList)
                }
            }
         }
     }
}