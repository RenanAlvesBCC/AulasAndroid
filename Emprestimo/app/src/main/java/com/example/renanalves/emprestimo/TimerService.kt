package com.example.renanalves.emprestimo

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import com.example.renanalves.emprestimo.Model.AlertReceiver
import java.util.*

class TimerService: Service() {

    override fun onCreate(){
        setAlarm()
        super.onCreate()
    }

    override fun onDestroy(){
        super.onDestroy()
    }

    fun setAlarm(){

        val alertTime: Long = GregorianCalendar().timeInMillis+5*1000
        val alertIntent: Intent = Intent(this, AlertReceiver::class.java)

        val manager: AlarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        manager.set(AlarmManager.RTC_WAKEUP, alertTime, PendingIntent.getBroadcast(this, 1, alertIntent, PendingIntent.FLAG_UPDATE_CURRENT))
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

}