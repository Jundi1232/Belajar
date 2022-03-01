package com.example.submission1_made

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.submission1_made.databinding.ActivityDetailUserBinding

class DetailActivityUser : AppCompatActivity() {
    private lateinit var binding:ActivityDetailUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data=intent.getParcelableExtra<User>("DATA")
        if (data != null) {
            binding.tvDetailUser.text= data.name
            binding.tvDetailUsername.text=data.username
            binding.imageDetailAvatar.setImageResource(data.img)
        }


    }
}