package com.example.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.roomdatabase.databinding.ActivityAddBinding
import com.example.roomdatabase.room.AppDatabase
import com.example.roomdatabase.room.User
import kotlinx.coroutines.launch

class AddActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnAddUser.setOnClickListener { adduser() }
    }

    private fun adduser() {
        val firstName=binding.edtName.text.toString()
        val lastName=binding.edtFamily.text.toString()
        lifecycleScope.launch {
            val user=User(fitstName = firstName, lastName = lastName)
            AppDatabase(this@AddActivity).getUserDao().addUser(user)
            finish()
        }

    }
}