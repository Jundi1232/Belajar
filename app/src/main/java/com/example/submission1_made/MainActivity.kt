package com.example.submission1_made

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvUser: RecyclerView
    private val list=ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvUser=findViewById(R.id.rv_User)
        rvUser.setHasFixedSize(true)
        list.addAll(listUsers)
        showRecyclerList()
    }
    private val listUsers: ArrayList<User>
        @SuppressLint("Recycle")
        get() {
            val dataname=resources.getStringArray(R.array.name)
            val datausername=resources.getStringArray(R.array.username)
            val dataAvatar=resources.obtainTypedArray(R.array.avatar)
            val listUser=ArrayList<User>()
            for (i in dataname.indices){
                val user=User(dataname[i],datausername[i],dataAvatar.getResourceId(i,-1))
                listUser.add(user)
            }
            return listUser
        }

    private fun showRecyclerList() {
        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvUser.layoutManager = GridLayoutManager(this, 2)
        } else {
            rvUser.layoutManager = LinearLayoutManager(this)
        }
        val listUserAdapter=ListUserAdapter(list)
        rvUser.adapter=listUserAdapter
        listUserAdapter.setOnItemClickCallback(object : ListUserAdapter.OnItemClickCallback{
            override fun onItemClicked(data: User) {
                showSelectedUser(data)
                val intentToDetail=Intent(this@MainActivity,DetailActivityUser::class.java)
                intentToDetail.putExtra("DATA",data)
                startActivity(intentToDetail)
            }
        })
    }
    private fun showSelectedUser(user:User){
        Toast.makeText(this,"Kamu Memilih"+ user.name,Toast.LENGTH_SHORT).show()
    }
}