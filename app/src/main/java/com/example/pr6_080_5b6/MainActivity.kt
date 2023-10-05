package com.example.pr6_080_5b6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    var toggleButton=true;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val playButton=findViewById<FloatingActionButton>(R.id.floatingaction3)
        val stopButton=findViewById<FloatingActionButton>(R.id.floatingaction4)
        playButton.setOnClickListener{
            Intent(applicationContext,MyService2::class.java).
                    putExtra("service1","PlayPause").apply{
                        startService(this)
            }
            if(toggleButton){
                toggleButton=false;
                playButton.setImageResource(R.drawable.baseline_pause_24)
            }
            else{
                toggleButton=true;
                playButton.setImageResource(R.drawable.baseline_play_arrow_24)
            }
        }
        stopButton.setOnClickListener{
            Intent(applicationContext,MyService2::class.java).apply { stopService(this)
            }
            if(!toggleButton) {
                toggleButton = true;
                playButton.setImageResource(R.drawable.baseline_play_arrow_24)
            }
        }

        }
    }

