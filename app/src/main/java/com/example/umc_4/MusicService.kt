package com.example.umc_4

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

class MusicService : Service() {

    lateinit var mp : MediaPlayer

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onCreate() {
        super.onCreate()
        mp = MediaPlayer.create(this,R.raw.yours)
        mp.isLooping = false // 반복재생
    }

    // 서비스가 호출될때마다 호출 (음악재생)
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        mp.start()
        return super.onStartCommand(intent, flags, startId)
    }

    // 서비스가 종료될 때 음악 종료
    override fun onDestroy() {
        super.onDestroy()
        mp.stop()
    }
}