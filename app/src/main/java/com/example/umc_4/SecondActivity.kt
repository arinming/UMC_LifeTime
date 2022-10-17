package com.example.umc_4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.umc_4.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySecondBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        binding.txtSecond.text=intent.getStringExtra("data")
    }
}