package com.example.pr6_080_5b6

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log

class MyService2 : Service() {
    lateinit var mediaPlayer: MediaPlayer
    val TAG="MyService2"
    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }
    override fun onStartCommand(intent: Intent?, flags: Int,startId:Int): Int{
        if(!this::mediaPlayer.isInitialized)
            mediaPlayer= MediaPlayer.create(this,R.raw.song)
        if (intent!=null) {
            val str1:String?=intent.getStringExtra("Service1")
            if (str1=="PlayPause"){
                if (!mediaPlayer.isPlaying)
                    mediaPlayer.start()
                else
                    mediaPlayer.pause()
                Log.i(TAG,"onStartCommand")

            }
        }
        else{
            mediaPlayer.start()
        }
        return START_STICKY
        }

    override fun onDestroy() {
        mediaPlayer.stop()
        super.onDestroy()
    }
    }