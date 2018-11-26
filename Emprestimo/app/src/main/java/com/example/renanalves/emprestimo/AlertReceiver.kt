package com.example.renanalves.emprestimo

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.support.v4.app.NotificationCompat

class AlertReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent){
        sendNotification(context, "Sample", "Notification sent....")
    }

    fun sendNotification(context: Context, title: String, body: String){
        val notification = NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.notification_icon_background)
                .setContentTitle(title)
                .setContentText(body)

        val pendingIntent: PendingIntent = PendingIntent.getActivity(context, 0, Intent(context, TimerService::class.java), 0)

        notification.setContentIntent(pendingIntent)
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(1, notification.build())
    }

}