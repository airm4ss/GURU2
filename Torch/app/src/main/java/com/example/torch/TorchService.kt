package com.example.torch

import android.app.Service
import android.content.Intent
import android.os.IBinder

class TorchService : Service() {

    private val torch: Torch by lazy{
        Torch(this)
    }
    private var isRunning = false

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        //앱
        when(intent?.action){
            "on" ->{
                torch.flashOn()
            }
            "off" ->{
                torch.flashOff()
            }

            //위젯
            else -> {
                isRunning = !isRunning
                if(isRunning){
                    torch.flashOn()
                }
                else{
                    torch.flashOff()
                }
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }
}