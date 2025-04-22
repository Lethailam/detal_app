package com.example.doctors_appointment.util

import android.util.Log
import com.example.doctors_appointment.data.service.NotificationHelper
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d("FCM", "🌐 New token: $token")
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)

        val title = message.notification?.title ?: "Thông báo"
        val body = message.notification?.body ?: "Bạn có lịch hẹn mới!"

        NotificationHelper.showNotification(applicationContext, title, body)
    }
}