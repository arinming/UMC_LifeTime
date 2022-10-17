package com.example.umc_4

import android.content.Intent
import android.media.MediaPlayer
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

    override fun onStart() {
        super.onStart()
        val intent = Intent(this, MusicService::class.java)
        startService(intent) // 서비스 시작
    }

    override fun onPause() {
        super.onPause()
        val intent = Intent(this, MusicService::class.java)
        stopService(intent) // 서비스 종료
    }
}