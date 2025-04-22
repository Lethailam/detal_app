package com.example.doctors_appointment.data.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.doctors_appointment.R

object NotificationHelper {

    private const val CHANNEL_ID = "appointment_channel"
    private const val CHANNEL_NAME = "Appointment Notifications"

    fun showNotification(context: Context, title: String, message: String) {
        createChannel(context)

        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_nofication) // Bạn cần icon này trong drawable
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)
            .build()

        val notificationManager = NotificationManagerCompat.from(context)

        if (notificationManager.areNotificationsEnabled()) {
            try {
                notificationManager.notify(System.currentTimeMillis().toInt(), notification)
            } catch (e: SecurityException) {
                e.printStackTrace()
                Log.e("Notification", "🚫 Không có quyền gửi thông báo: ${e.message}")
            }
        } else {
            Log.w("Notification", "⚠️ Người dùng chưa cấp quyền thông báo")
        }
    }

    private fun createChannel(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Thông báo lịch hẹn từ ứng dụng"
            }

            val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }
}