package com.example.splashscreen;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.annotation.RequiresApi;

public class AlarmReceiver extends BroadcastReceiver {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onReceive(Context context, Intent intent) {

        int notificationId=intent.getIntExtra("notificationId",0);
        String message=intent.getStringExtra("todo");
        Intent mainIntent= new Intent(context,setReminder.class);
        PendingIntent contextIntent=PendingIntent.getActivity(context,0,mainIntent,0);
        NotificationManager myNotificationmanager=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);

        Notification.Builder builder=new Notification.Builder(context);
        builder.setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("It's Time")
                .setContentText(message)
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setContentIntent(contextIntent)
                .setPriority(Notification.PRIORITY_MAX)
                .setDefaults(Notification.DEFAULT_ALL);


        myNotificationmanager.notify(notificationId,builder.build());

    }
}
