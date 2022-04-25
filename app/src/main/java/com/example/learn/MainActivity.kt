package com.example.learn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.learn.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

private lateinit var userRecyclerView: RecyclerView
private lateinit var userList: ArrayList<User>
private lateinit var adapter: UserAdapter

    var binding: ActivityMainBinding? =  null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        userList = ArrayList()
        adapter = UserAdapter(this,userList)
    }
}